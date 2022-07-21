package com.oa.manage.controller;

import com.oa.commons.ExcelOperate;
import com.oa.manage.service.DutyService;
import com.oa.pojo.Duty;
import com.oa.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class DutyController {
    @Autowired
    private DutyService dutyService;

    /**
     * 签到处理,只能签一次,签过了不能再签
     *
     * @return
     */
    @RequestMapping("/signIn")
    @ResponseBody
    public String signIn(HttpSession session) {
        //只能签一次,先查询当天这个用户有没有签到数据,如果有,那就是已经签过
        Employee employee = (Employee) session.getAttribute("emp");
        String empid = employee.getEmpid();
        //当天的日期
        Date date = new Date();
        //数据库中需要的是只有年月日的date,对应java中是java.sql.Date
        java.sql.Date currentDay = new java.sql.Date(date.getTime());
        Duty duty = dutyService.findDuty(currentDay, empid);
        if (duty != null) {
            //已经签过了
            return "2";
        } else {
            //可以签到
            //数据库中需要当天签到时的时分秒的数据
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            //时分秒
            String signInTime = sdf.format(new Date());
            Duty duty1 = new Duty();
            duty1.setDtdate(currentDay);
            duty1.setEmprid(empid);
            duty1.setSignintime(signInTime);
            //把数据写入数据库
            int n = dutyService.addDutyData(duty1);
            if (n == 1) {
                return "1";
            } else {
                return "0";//签到失败
            }
        }


    }

    /**
     * 签退处理
     */
    @RequestMapping("/signOut")
    @ResponseBody
    public String signOut(HttpSession session) {
        //先查询是否签到过
        Employee employee = (Employee) session.getAttribute("emp");
        String empid = employee.getEmpid();
        //当天的日期
        Date date = new Date();
        //数据库中需要的是只有年月日的date,对应java中是java.sql.Date
        java.sql.Date currentDay = new java.sql.Date(date.getTime());
        Duty duty = dutyService.findDuty(currentDay, empid);
        if (duty != null) {
            //已经签到过,修改签退时间
            //数据库中需要当天签到时的时分秒的数据
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            //时分秒
            String signOutTime = sdf.format(new Date());
            Duty duty1 = new Duty();
            duty1.setEmprid(empid);
            duty1.setDtdate(currentDay);
            duty1.setSignouttime(signOutTime);
            int n = dutyService.updateDuty(duty1);
            if (n == 1) {
                return "1";
            } else {
                return "0";
            }
        } else {
            //没有签到数据
            //数据库中需要当天签到时的时分秒的数据
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            //时分秒
            String signInTime = sdf.format(new Date());
            Duty duty1 = new Duty();
            duty1.setDtdate(currentDay);
            duty1.setEmprid(empid);
            duty1.setSignouttime(signInTime);
            //把数据写入数据库
            int n = dutyService.addDutyData(duty1);
            if (n == 1) {
                return "1";
            } else {
                return "0";//签到失败
            }
        }
    }

    /**
     * 显示所有的考勤信息
     */
    @RequestMapping("/showDutyList")
    public String showDutyList(Model model) {
        List<Duty> dutyList = dutyService.findAllDuty();
        model.addAttribute("dutyList", dutyList);
        return "dutyList";
    }

    @RequestMapping("/outDutyExcel")
    @ResponseBody
    public String outDutyExcel() {
        /*
        把所有的数据都放入list集合,如果数据库中数据特别多,
        多到list集合一次性装不下,会造成内存溢出,怎么处理?
        分页查询出来,使用异步循环处理
         */
        String all = dutyService.findAll();
        return all;
    }


}


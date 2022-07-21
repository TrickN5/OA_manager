package com.oa.manage.controller;

import com.oa.commons.SmsSender;
import com.oa.manage.service.UserService;
import com.oa.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param employee
     * @param session
     * @param m
     * @return
     */
    @RequestMapping("/loginUser")
    public String loginUser(Employee employee, HttpSession session, Model m) {
        Employee emp = userService.loginUser(employee);
        if (emp != null) {
            //把登录身份放入session
            session.setAttribute("emp", emp);
            return "redirect:/main";
        } else {
            //登录失败
            m.addAttribute("msg", "用户名或密码有误!");
            return "login";
        }


    }

    /**
     * 退出
     */
    @RequestMapping(value = "/logout", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String logout(HttpSession session) {
        //强制销毁session
        session.invalidate();
        return "谢谢使用";
    }




    String backCode;

    /**
     * 发送短信处理
     */
    @RequestMapping("/smsSend")
    @ResponseBody
    public String smsSend(String phone) {
        //根据phone查询是否存在该用户
        Employee emp = userService.selectByPhone(phone);
        if (emp != null) {
            //发送短信验证码,6位验证码
            //backCode = smsSender.getCode();//模拟
            try {
                backCode = SmsSender.sendSms(phone);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("随机验证码:" + backCode);

            return "1";
        } else {
            //手机号没有对应的用户
            return "2";
        }
    }

    /**
     * 短信登录校验处理
     *
     * @param phone 用户提交的手机号
     * @param code  用户收到的验证码
     * @return
     */
    @RequestMapping("smsLogin")
    public String smsLogin(String phone, String code, HttpSession session) {
        if (code.equals(backCode)) {
            //验证码校验成功，说明可以登录，根据phone查询出用户的信息，放入session中
            Employee employee = userService.selectByPhone(phone);
            session.setAttribute("emp", employee);
            return "redirect:/main";
        } else {
            return "/smsLogin";
        }
    }
}

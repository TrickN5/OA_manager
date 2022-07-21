package com.oa.manage.service.impl;


import com.oa.commons.ExcelOperate;
import com.oa.manage.service.DeptService;
import com.oa.manage.service.DutyService;
import com.oa.manage.service.EmpService;
import com.oa.mapper.DutyMapper;
import com.oa.pojo.Dept;
import com.oa.pojo.Duty;
import com.oa.pojo.DutyExample;
import com.oa.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Async  //异步调用(多线程调用当前的方法)
public class DutyServiceImpl implements DutyService {
    @Autowired
    private DutyMapper dutyMapper;

    @Override
    public Duty findDuty(Date date, String empid) {
        DutyExample exp = new DutyExample();
        exp.createCriteria().andDtdateEqualTo(date).andEmpridEqualTo(empid);
        List<Duty> duties = dutyMapper.selectByExample(exp);
        if (duties != null && duties.size() == 1) {
            return duties.get(0);
        }
        return null;
    }


    @Override
    public int addDutyData(Duty duty1) {
        return dutyMapper.insert(duty1);
    }

    @Override
    public int updateDuty(Duty duty1) {
        DutyExample exp = new DutyExample();
        //封装修改条件
        exp.createCriteria().andEmpridEqualTo(duty1.getEmprid()).andDtdateEqualTo(duty1.getDtdate());
        return dutyMapper.updateByExampleSelective(duty1, exp);
    }

    @Autowired
    private EmpService empService;
    @Autowired
    private DeptService deptService;

    @Override
    public String findAll() {
        List<Duty> duties = dutyMapper.selectByExample(null);
        for (Duty duty : duties) {
            String empid = duty.getEmprid();
            //根据empid查employee数据
            Employee employee = empService.selectEmpById(empid);
            duty.setEmployee(employee);
            //根据employee中提供的deptno查对应的部门信息
            Dept dept = deptService.checkDeptNo(employee.getDeptno());
            duty.setDept(dept);
            java.util.Date dtdate = duty.getDtdate();
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            String format = f.format(dtdate);
            duty.setSdtdate(format);
        }
        ExcelOperate.createExcel(duties);
        return "1";
    }

    @Override
    public List<Duty> findAllDuty() {
        List<Duty> dutys = dutyMapper.selectByExample(null);
        for (Duty duty : dutys) {
            String empid = duty.getEmprid();
            //根据empid查empolyee数据
            Employee employee = empService.selectEmpById(empid);
            duty.setEmployee(employee);
            //根据employee中提供的deptno查对应的部门信息
            Dept dept = deptService.checkDeptNo(employee.getDeptno());
            duty.setDept(dept);
            java.util.Date dtdate = duty.getDtdate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String format = sdf.format(dtdate);
            duty.setSdtdate(format);
        }
        return dutys;
    }
}

package com.oa.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.manage.service.EmpService;
import com.oa.mapper.DeptMapper;
import com.oa.mapper.DutyMapper;
import com.oa.mapper.EmployeeMapper;
import com.oa.mapper.PositionMapper;
import com.oa.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    PositionMapper positionMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DeptMapper deptMapper;
    @Autowired
    DutyMapper dutyMapper;

    @Override
    public List<Dept> selectAllDept() {
        return deptMapper.selectByExample(null);
    }

    @Override
    public List<Employee> selectAllMgr() {
        EmployeeExample exp = new EmployeeExample();
        exp.createCriteria().andEmptypeEqualTo(1);
        return employeeMapper.selectByExample(exp);
    }

    @Override
    public List<Position> selectAllPos() {
        return positionMapper.selectByExample(null);
    }

    @Override
    public int addEmployee(Employee emp) {
        return employeeMapper.insertSelective(emp);
    }

    @Override
    public List<Employee> selectAllEmp() {
        List<Employee> employees = employeeMapper.selectByExample(null);
        for (Employee emp : employees) {
            // 基于员工中持有的deptno查当前员工的部门信息
            Integer deptno = emp.getDeptno();
            Dept dept = deptMapper.selectByPrimaryKey(deptno);
            emp.setDept(dept);
            // 基于员工中持有的posid查当前员工的岗位信息
            Integer posid = emp.getPosid();
            Position position = positionMapper.selectByPrimaryKey(posid);
            emp.setPosition(position);
            //转化入职日期的格式
            Date hiredate = emp.getHiredate();
            //日期格式的转化类
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String sHiredate = sdf.format(hiredate);
            emp.setsHiredate(sHiredate);

            Date birthdate = emp.getBirthdate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = dateFormat.format(birthdate);
            emp.setsBirthdate(format);

            //根据mgrid查员工的上级信息
            Employee employee = employeeMapper.selectByPrimaryKey(emp.getMgrid());
            emp.setMgr(employee);

        }

        return employees;
    }

    @Override
    public List<Employee> MultyFind(String empid, int deptno, int onduty, String hiredate) {
        EmployeeExample exp = new EmployeeExample();
        EmployeeExample.Criteria criteria = exp.createCriteria();
        //条件empid
        if (empid != null && !"".equals(empid)) {
            criteria.andEmpidLike("%" + empid + "%");
        }
        //条件 deptno
        if (deptno != -1) {
            criteria.andDeptnoEqualTo(deptno);
        }
        //条件onduty
        criteria.andOndutyEqualTo(onduty);
        //入职日期
        if (hiredate != null && !"".equals(hiredate)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = null;
            try {
                parse = sdf.parse(hiredate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //  >= hiredate
            criteria.andHiredateGreaterThanOrEqualTo(parse);
        }
        List<Employee> employees = employeeMapper.selectByExample(exp);
        for (Employee emp : employees) {
            // 基于员工中持有的deptno查当前员工的部门信息
            Dept dept = deptMapper.selectByPrimaryKey(emp.getDeptno());
            emp.setDept(dept);
            // 基于员工中持有的posid查当前员工的岗位信息
            Integer posid = emp.getPosid();
            Position position = positionMapper.selectByPrimaryKey(posid);
            emp.setPosition(position);
            //转化入职日期的格式
            //日期格式的转化类
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String sHiredate = sdf.format(emp.getHiredate());
            emp.setsHiredate(sHiredate);

        }
        return employees;
    }

    @Override
    public Employee selectEmpById(String empid) {
        Employee emp = employeeMapper.selectByPrimaryKey(empid);

        // 基于员工中持有的deptno查当前员工的部门信息
        Integer deptno = emp.getDeptno();
        Dept dept = deptMapper.selectByPrimaryKey(deptno);
        emp.setDept(dept);
        // 基于员工中持有的posid查当前员工的岗位信息
        Integer posid = emp.getPosid();
        Position position = positionMapper.selectByPrimaryKey(posid);
        emp.setPosition(position);
        //转化入职日期的格式
        Date hiredate = emp.getHiredate();
        //日期格式的转化类

        String sHiredate = changeDateFormat(hiredate);
        emp.setsHiredate(sHiredate);

        String sBirthdate = changeDateFormat(emp.getBirthdate());
        emp.setsBirthdate(sBirthdate);

        String sLeavedate = changeDateFormat(emp.getLeavedate());
        emp.setsLeavedate(sLeavedate);
        //根据mgrid查员工的上级信息
        Employee employee = employeeMapper.selectByPrimaryKey(emp.getMgrid());
        emp.setMgr(employee);


        return emp;
    }


    /**
     * 封装日期格式转化
     */
    public String changeDateFormat(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        return format;
    }

    @Override
    public int updateEmployee(Employee emp) {
        return employeeMapper.updateByPrimaryKeySelective(emp);
    }

    @Override
    public int deleteEmpByNo(String empid) throws SQLIntegrityConstraintViolationException {
        int n;
        try {
            n = employeeMapper.deleteByPrimaryKey(empid);
        } catch (Exception e) {
            throw new SQLIntegrityConstraintViolationException("有外键");
        }
        return n;
    }

    @Override
    public String updatePassword(Employee employee) {
        String newPassword = employee.setPassword("123456");
        EmployeeExample exp = new EmployeeExample();
        exp.createCriteria().andEmpidEqualTo(employee.getEmpid());
        int result = employeeMapper.updateByExample(employee, exp);
        if (result <= 0) {
            return newPassword;
        }
        return "重置密码失败";
    }



}

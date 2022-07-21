package com.oa.manage.service.impl;

import com.oa.manage.service.UserService;
import com.oa.mapper.EmployeeMapper;
import com.oa.pojo.Employee;
import com.oa.pojo.EmployeeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    //使用***mapper
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Employee loginUser(Employee employee) {
        EmployeeExample exp = new EmployeeExample();
        exp.createCriteria().andEmpidEqualTo(employee.getEmpid()).andPasswordEqualTo(employee.getPassword());
        List<Employee> employees = employeeMapper.selectByExample(exp);
        if (employees != null && employees.size() == 1) {
            return employees.get(0);
        }
        return null;
    }

    @Override
    public Employee selectByPhone(String phone) {
        EmployeeExample exp = new EmployeeExample();
        exp.createCriteria().andPhoneEqualTo(phone);
        List<Employee> employees = employeeMapper.selectByExample(exp);
        if (employees != null && employees.size() == 1) {
            return employees.get(0);
        }
        return null;
    }
}

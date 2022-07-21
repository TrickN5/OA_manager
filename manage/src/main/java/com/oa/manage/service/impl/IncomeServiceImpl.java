package com.oa.manage.service.impl;


import com.oa.manage.service.EmpService;
import com.oa.manage.service.IncomeService;
import com.oa.mapper.DeptMapper;
import com.oa.mapper.DutyMapper;
import com.oa.mapper.IncomeMapper;
import com.oa.pojo.Dept;
import com.oa.pojo.Employee;
import com.oa.pojo.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeMapper incomeMapper;

    @Autowired
    DeptMapper deptMapper;
    @Autowired
    EmpService empService;

    @Override
    public List<Dept> selectAllDept() {
        return deptMapper.selectByExample(null);
    }


    @Override
    public int addIncome(Income income) {
        return incomeMapper.insertSelective(income);
    }

    @Override
    public List<Income> findAllIncome() {
        List<Income> incomes = incomeMapper.selectByExample(null);
        for (Income income : incomes) {
            String userid = income.getUserid();
            Employee employee = empService.selectEmpById(userid);
            income.setEmployee(employee);
        }
        return incomes;
    }
}

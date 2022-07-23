package com.oa.manage.service;

import com.oa.commons.IncomeData;
import com.oa.pojo.Dept;
import com.oa.pojo.Employee;
import com.oa.pojo.Income;

import java.util.List;

public interface IncomeService {

    int addIncome(Income income);

    List<Dept> selectAllDept();

    List<Income> findAllIncome();

    public List<IncomeData> getIncomeDatas();
}

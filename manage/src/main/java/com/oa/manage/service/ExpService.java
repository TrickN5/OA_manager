package com.oa.manage.service;

import com.oa.pojo.*;

import java.util.List;

public interface ExpService {
    public List<Employee> getAllMgr();

    public int addExpense(Expense expense, List<Expenseitem> list, List<Expimage> expimages);

    List<Expense> selectExpByAudit(String empid);

    List<Expenseitem> findExpItem(int expid);

    List<Expimage> findExpImg(int expid);

    int auditing(Auditing auditing);

    List<Auditing> findExpenseHistory(int expid);

    List<Expense> selectExpenseById(String empid);

    List<Auditing> selectAuditingById(String empid);
}

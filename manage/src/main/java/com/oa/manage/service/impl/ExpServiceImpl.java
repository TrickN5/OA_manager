package com.oa.manage.service.impl;

import com.oa.manage.service.EmpService;
import com.oa.manage.service.ExpService;
import com.oa.mapper.*;
import com.oa.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional  //加入事务处理
public class ExpServiceImpl implements ExpService {

    @Autowired
    private ExpenseMapper expenseMapper;
    @Autowired
    private ExpenseitemMapper expenseitemMapper;
    @Autowired
    private ExpimageMapper expimageMapper;

    @Autowired
    private EmpService empService;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private AuditingMapper auditingMapper;

    @Override
    public List<Employee> getAllMgr() {
        EmployeeExample exp = new EmployeeExample();
        exp.createCriteria().andEmptypeEqualTo(1);
        return employeeMapper.selectByExample(exp);
    }

    @Override
    public int addExpense(Expense expense, List<Expenseitem> list, List<Expimage> expimages) {
        expenseMapper.insert(expense);

        for (Expenseitem expenseitem : list) {
            expenseitemMapper.insert(expenseitem);
        }
        for (Expimage expimage : expimages) {
            expimageMapper.insert(expimage);
        }
        return 1;
    }

    @Override
    public List<Expense> selectExpByAudit(String empid) {
        ExpenseExample exp = new ExpenseExample();
        exp.createCriteria().andNextauditorEqualTo(empid);
        List<Expense> expenses = expenseMapper.selectByExample(exp);
        for (Expense expens : expenses) {
            String expensEmpid = expens.getEmpid();
            Employee employee = empService.selectEmpById(expensEmpid);
            expens.setEmployee(employee);
            Date exptime = expens.getExptime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String format = sdf.format(exptime);
            expens.setSexptime(format);
        }
        return expenses;
    }

    @Override
    public List<Expenseitem> findExpItem(int expid) {
        ExpenseitemExample exp = new ExpenseitemExample();
        exp.createCriteria().andExpidEqualTo(expid);
        return expenseitemMapper.selectByExample(exp);
    }

    @Override
    public List<Expimage> findExpImg(int expid) {
        ExpimageExample exp = new ExpimageExample();
        exp.createCriteria().andExpidEqualTo(expid);
        return expimageMapper.selectByExample(exp);
    }

    /**
     * @param auditing
     * @return
     */
    @Override
    public int auditing(Auditing auditing) {
        //根据expid查询获取需要审核的报销单
        Integer expid = auditing.getExpid();
        //待审核的报销单信息
        Expense expense = expenseMapper.selectByPrimaryKey(expid);
        /*
         * 审核逻辑:
         * 员工-->主管---->报销金额 > 2500--->总裁审核--->财务--->打款
         * 员工-->主管---->报销金额 <= 2500--->财务--->打款
         */
        if ("1".equals(auditing.getResult())) {  //通过审核
            //进入审核
            if ("xiaoqiao".equals(auditing.getEmpid())) { //是财务
                //添加财务支出

                //添加审核记录(审核信息写入auditing表中)
                auditingMapper.insert(auditing);
                //修改报销单的状态(已经打款),下一个审核人: 空
                expense.setLastresult("已经打款");
                expense.setStatus("4"); //1带审核,2,通过,3 驳回,4 已打款
                expense.setNextauditor(" "); //已经报销完毕,没有审核人了
                expenseMapper.updateByPrimaryKey(expense);
                System.out.println("财务已经打款处理完毕");
            } else { //不是财务
                //判断金额
                if (expense.getTotalamount() <= 2500) {
                    //当前的审核人是直接主管,有权直接审核进入财务打款
                    //添加审核记录
                    auditingMapper.insert(auditing);
                    //修改报销单状态,下一个审核人是: 财务
                    expense.setLastresult("审核通过");
                    expense.setStatus("2"); //1带审核,2,通过,3 驳回,4 已打款
                    expense.setNextauditor("xiaoqiao"); // 下一个审核人是交给财务打款处理
                    expenseMapper.updateByPrimaryKey(expense);
                    System.out.println("主管审核完毕");

                } else {  //  报销额 > 2500的情况,必须由总裁审核
                    //判断当前审核人是否是总裁
                    if ("admin".equals(auditing.getEmpid())) {
                        //是总裁
                        //添加审核记录
                        auditingMapper.insert(auditing);
                        //修改报销单状态,下一个审核人是: 财务
                        expense.setLastresult("通过审核");
                        expense.setStatus("2"); //1带审核,2,通过,3 驳回,4 已打款
                        expense.setNextauditor("xiaoqiao"); // 下一个审核人是交给财务打款处理
                        expenseMapper.updateByPrimaryKey(expense);
                        System.out.println("总裁审核完毕");

                    } else {
                        //不是总裁,当前是普通的主管,需要再提交给总裁审核的
                        //添加审核记录
                        auditingMapper.insert(auditing);
                        //修改报销单状态,下一个审核人是: 总裁
                        expense.setLastresult("通过审核");
                        expense.setStatus("2"); //1待审核,2,通过,3 驳回,4 已打款
                        expense.setNextauditor("admin"); // 下一个审核人是交给总裁审核
                        expenseMapper.updateByPrimaryKey(expense);
                        System.out.println("主管审核完毕");
                    }
                }
            }

        } else {  //决绝或驳回的情况
            //添加审核记录
            auditingMapper.insert(auditing);
            //修改报销单的状态及下一个审核人
            expense.setLastresult("驳回");
            expense.setStatus("3"); //1带审核,2,通过,3 驳回,4 已打款
            expenseMapper.updateByPrimaryKey(expense);
            System.out.println("拒绝");
        }
        return 1;
    }

    @Override
    public List<Auditing> findExpenseHistory(int expid) {
        AuditingExample exp = new AuditingExample();
        exp.createCriteria().andExpidEqualTo(expid);
        List<Auditing> auditings = auditingMapper.selectByExample(exp);
        for (Auditing auditing : auditings) {
            String empid = auditing.getEmpid();
            Employee employee = empService.selectEmpById(empid);
            Date time = auditing.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String format = sdf.format(time);
            auditing.setStime(format);
            auditing.setEmployee(employee);
        }
        return auditings;
    }

    @Override
    public List<Expense> selectExpenseById(String empid) {
        ExpenseExample exp = new ExpenseExample();
        exp.createCriteria().andEmpidEqualTo(empid);
        List<Expense> expenses = expenseMapper.selectByExample(exp);
        for (Expense expens : expenses) {
            Date exptime = expens.getExptime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String format = sdf.format(exptime);
            expens.setSexptime(format);
        }
        return expenses;
    }

    @Override
    public List<Auditing> selectAuditingById(String empid) {
        AuditingExample exp = new AuditingExample();
        exp.createCriteria().andEmpidEqualTo(empid);
        List<Auditing> auditings = auditingMapper.selectByExample(exp);
        for (Auditing auditing : auditings) {
            Integer expid = auditing.getExpid();
            Expense expense = expenseMapper.selectByPrimaryKey(expid);

            Date stime = auditing.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String format = sdf.format(stime);
            auditing.setStime(format);

            Date expTime = expense.getExptime();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            String format1 = sdf1.format(expTime);
            auditing.setExpense(expense.setSexptime(format1));

            //报销单
            String empid1 = expense.getEmpid();
            //报销人id
            Employee employee = empService.selectEmpById(empid1);
            auditing.setEmployee(employee);
            auditing.setExpense(expense);
        }
        return auditings;
    }

}

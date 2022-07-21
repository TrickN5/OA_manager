package com.oa.manage.controller;


import com.oa.manage.service.EmpService;
import com.oa.manage.service.IncomeService;
import com.oa.pojo.Dept;
import com.oa.pojo.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IncomeController {

    @Autowired
    private IncomeService incomeService;


    @RequestMapping("/incomeAddbefore")
    public String incomeAddbefore(Model model) {
        //查所有部门的信息
        List<Dept> depts = incomeService.selectAllDept();
        model.addAttribute("depts", depts);
        return "incomeAdd";
    }

    @RequestMapping("/addIncome")
    @ResponseBody
    public String addIncome(Income income) {
        int i = incomeService.addIncome(income);
        if (i == 1) {
            return "收入添加成功";
        }
        return "收入添加失败";
    }

    @RequestMapping("/showIncomeList")
    public String showIncomeList(Model model) {
        List<Income> allIncome = incomeService.findAllIncome();
        model.addAttribute("allIncome", allIncome);
        return "incomeList";
    }
}

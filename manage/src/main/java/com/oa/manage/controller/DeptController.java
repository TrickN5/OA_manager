package com.oa.manage.controller;

import com.oa.manage.service.DeptService;
import com.oa.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

@Controller
public class DeptController {

    @Autowired
    DeptService deptService;

    @RequestMapping(value = "/addDept", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addDept(Dept dept) {
        int i = deptService.addDept(dept);
        if (i == 1) {
            return "部门添加成功";
        }
        return "部门添加失败";
    }

    /**
     * 校验
     */
    @RequestMapping(value = "/checkDeptNo", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String checkDeptNo(int deptno) {
        System.out.println("deptno:" + deptno);
        //查数据库核对DeptNo是否存在
        Dept dept = deptService.checkDeptNo(deptno);
        if (dept != null) {
            return "编号已存在";
        }
        return "可以用";
    }

    /**
     * 校验
     */
    @RequestMapping(value = "/checkDeptName", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String checkDeptName(String deptname) {
        System.out.println("deptname:" + deptname);
        //查数据库核对DeptNo是否存在
        Dept dept = deptService.checkDeptName(deptname);
        if (dept != null) {
            return "部门名称已存在";
        }
        return "可以用";
    }

    /**
     * 显示所有部门
     */
    @RequestMapping("/showDeptList")
    public String showDeptList(Model model) {
        //从数据库中查询所有的部门数据
        Map<String, Object> map = deptService.selectAllDepts(1, 3);
        System.out.println(map);
        long total = deptService.getTotal();
        model.addAttribute("depts", map.get("depts"));
        model.addAttribute("pageNum", map.get("pageNum"));
        model.addAttribute("total", total);
        return "deptList";
    }

    int pageNum = 1;

    /**
     * 换页
     */
    @RequestMapping("/dumpTo/{pageNum}")
    public String dumpTo(@PathVariable int pageNum, Model model) {
        this.pageNum = pageNum;
        //从数据库中查询所有的部门数据
        Map<String, Object> map = deptService.selectAllDepts(pageNum, 3);
        long total = deptService.getTotal();
        model.addAttribute("depts", map.get("depts"));
        model.addAttribute("pageNum", map.get("pageNum"));
        model.addAttribute("total", total);
        return "deptList";
    }

    /**
     * 上一页
     *
     * @return
     */
    @RequestMapping("/dumpToPre")
    public String dumpToPre(Model model) {
        --pageNum;
        //避免页码进入负数
        if (this.pageNum <= 1) {
            this.pageNum = 1;
        }
        //从数据库中查询所有的部门数据
        Map<String, Object> map = deptService.selectAllDepts(pageNum, 3);
        long total = deptService.getTotal();
        model.addAttribute("depts", map.get("depts"));
        model.addAttribute("pageNum", map.get("pageNum"));
        model.addAttribute("total", total);
        return "deptList";
    }

    /**
     * 下一页
     *
     * @return
     */
    @RequestMapping("/dumpToNext")
    public String dumpToNext(Model model) {
        //从数据库中查询所有的部门数据
        Map<String, Object> map = deptService.selectAllDepts(++pageNum, 3);
        long total = deptService.getTotal();
        model.addAttribute("depts", map.get("depts"));
        model.addAttribute("pageNum", map.get("pageNum"));
        model.addAttribute("total", total);
        return "deptList";
    }

    /**
     * 修改
     */
    @RequestMapping("/updateDept")
    @ResponseBody
    public String updateDept(Dept dept) {
        System.out.println(dept);
        //访问数据库，修改数据
        int n = deptService.updateDept(dept);
        if (n == 1) {
            return "修改成功";
        }
        return "修改失败!";
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteDept/{deptno}")
    @ResponseBody
    public String deleteDept(@PathVariable int deptno) {
        int n = 0;
        try {
            n = deptService.deleteDeptByNo(deptno);
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            return "当前部门下有员工不能删除,如果要删除,必须先删除此部门下所有的员工";
        }
        if (n == 1) {
            return "删除成功";
        }
        return "删除失败";
    }
}

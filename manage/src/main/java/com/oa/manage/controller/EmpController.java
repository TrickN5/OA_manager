package com.oa.manage.controller;


import com.oa.manage.service.EmpService;
import com.oa.pojo.Dept;
import com.oa.pojo.Employee;
import com.oa.pojo.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping("empAddbefore")
    public String empAddbefore(Model model) {
        //查所有部门的信息
        List<Dept> depts = empService.selectAllDept();
        model.addAttribute("depts", depts);
        //查所有职位的信息
        List<Position> positions = empService.selectAllPos();
        model.addAttribute("positions", positions);
        //查所有上级的信息
        List<Employee> mgrs = empService.selectAllMgr();
        model.addAttribute("mgrs", mgrs);
        return "empAdd";
    }

    /**
     * 添加员工
     */
    @RequestMapping(value = "/addEmployee", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addEmployee(String empid, String realname, @RequestParam(defaultValue = "123") String password, String sex, Date birthdate, Date hiredate, String leavedate, int onduty, int emptype, int deptno, int posid, String mgrid, String phone, String qq, String emercontactperson, String idcard) {
        Employee emp = new Employee();
        emp.setEmpid(empid);
        emp.setRealname(realname);
        emp.setPassword(password);
        emp.setSex(sex);
        emp.setBirthdate(birthdate);
        emp.setHiredate(hiredate);
        emp.setOnduty(onduty);
        emp.setEmptype(emptype);
        emp.setDeptno(deptno);
        emp.setDeptno(deptno);
        emp.setPosid(posid);
        emp.setMgrid(mgrid);
        emp.setPhone(phone);
        emp.setQq(qq);
        emp.setEmercontactperson(emercontactperson);
        emp.setIdcard(idcard);

        //把数据写入数据库
        int n = empService.addEmployee(emp);
        if (n == 1) {
            return "员工添加成功！";
        }
        return "添加失败";
    }

    /**
     * 显示所有员工
     */
    @RequestMapping("/showEmpList")
    public String showEmpList(Model model) {
        //查所有部门的信息
        List<Dept> depts = empService.selectAllDept();
        model.addAttribute("depts", depts);
        List<Employee> employees = empService.selectAllEmp();
        model.addAttribute("employees", employees);
        return "empList";
    }

    /**
     * 多条件查询
     */
    @RequestMapping("/multyFind")
    public String multyFind(String empid, int deptno, int onduty, String hiredate, Model m) {
        //查所有部门的信息
        List<Dept> depts = empService.selectAllDept();
        List<Employee> emps = empService.MultyFind(empid, deptno, onduty, hiredate);
        m.addAttribute("employees", emps);
        m.addAttribute("depts", depts);
        return "empList";
    }

    /**
     * 修改员工之前的处理
     */
    @RequestMapping("/empUpdateBrfore/{empid}")
    public String empUpdateBrfore(@PathVariable String empid, Model model) {
        Employee employee = empService.selectEmpById(empid);
        model.addAttribute("emp", employee);
        List<Dept> depts = empService.selectAllDept();
        model.addAttribute("depts", depts);
        List<Employee> mgrs = empService.selectAllMgr();
        model.addAttribute("mgrs", mgrs);
        return "empUpdate";
    }

    /**
     * 修改员工
     */
    @RequestMapping(value = "/updateEmp", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String updateEmp(String empid, String realname, String sex, Date birthdate, Date hiredate, String leavedate, int onduty, int deptno, String mgrid, String phone, String qq, String emercontactperson, String idcard) {
        Employee emp = new Employee();
        emp.setEmpid(empid);
        emp.setRealname(realname);
        emp.setSex(sex);
        emp.setBirthdate(birthdate);
        emp.setHiredate(hiredate);
        emp.setOnduty(onduty);
        emp.setDeptno(deptno);
        emp.setMgrid(mgrid);
        emp.setPhone(phone);
        emp.setQq(qq);
        emp.setEmercontactperson(emercontactperson);
        emp.setIdcard(idcard);
        //把数据写入数据库
        int n = empService.updateEmployee(emp);
        if (n == 1) {
            return "修改员工成功";
        }
        return "修改失败";
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteEmp/{empid}")
    @ResponseBody
    public String deleteEmp(@PathVariable String empid) {
        int n = 0;
        try {
            n = empService.deleteEmpByNo(empid);
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            return "有外键";
        }
        if (n == 1) {
            return "删除成功";
        }
        return "删除失败";
    }

    /**
     * 重置密码
     */
    @RequestMapping("/resetPassword/{empid}")
    public String resetPassword(@PathVariable String empid) {
        if (empid != null) {
            Employee employee = empService.selectEmpById(empid);
            empService.updatePassword(employee);
            return "redirect:/showEmpList";
        } else {
            return "重置失败";
        }
    }
}

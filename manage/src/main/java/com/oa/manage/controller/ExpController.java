package com.oa.manage.controller;

import com.oa.commons.IDUtils;
import com.oa.manage.service.EmpService;
import com.oa.manage.service.ExpService;
import com.oa.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ExpController {
    @Autowired
    private EmpService empService;

    @Autowired
    ExpService expService;

    @RequestMapping("/showExpenseAdd")
    public String showExpenseAdd(Model model, HttpSession session) {
        Employee emp = (Employee) session.getAttribute("emp");
        model.addAttribute("emp", emp);
        List<Employee> mgrs = empService.selectAllMgr();
        model.addAttribute("mgrs", mgrs);
        return "expenseAdd";
    }

    /**
     * 接收报销数据
     */
    @RequestMapping(value = "/exp/expAdd", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String expAdd(String[] type, Double[] amount, String[] itemdesc, String nextauditor, String expdesc, HttpSession session, MultipartFile[] photo) {
        //当前报销的人
        Employee emp = (Employee) session.getAttribute("emp");
        //报销单id
        long expid = IDUtils.genItemId();
        //封装报销单明细
        List<Expenseitem> expenseitems = new ArrayList<>();
        double totalaomount = 0.0;
        for (int i = 0; i < type.length; i++) {
            Expenseitem expenseitem = new Expenseitem();
            expenseitem.setType(type[i]);
            expenseitem.setItemdesc(itemdesc[i]);
            expenseitem.setAmount(amount[i]);
            expenseitem.setExpid((int) expid);
            //总额
            totalaomount += amount[i];
            expenseitems.add(expenseitem);
        }

        //封装报销单
        Expense exp = new Expense();
        exp.setExpid((int) expid);
        exp.setNextauditor(nextauditor);
        exp.setStatus("1"); //报销单状态: 1待审核,2通过,3驳回,4已打款
        exp.setLastresult("新提交"); //进入审核最后的修改状态:新提交,审核中,驳回,审核通过
        exp.setExptime(new Date());
        exp.setExpdesc(expdesc);
        exp.setEmpid(emp.getEmpid());
        exp.setTotalamount(totalaomount); //报销的总额

        List<Expimage> expimages = new ArrayList<>();
        /**
         * 报销凭证的上传
         */
        for (MultipartFile p : photo) {
            //  获取上传的每一个文件的原始文件名
            String originalFilename = p.getOriginalFilename();
            //获取文件的后缀
            int index = originalFilename.lastIndexOf("."); // 120.jpg
            String fileType = originalFilename.substring(index);
            //文件上传的位置(服务器中的某个目录)
            //获取服务器的上下文对象(与tomcat打交道的对象)
            ServletContext servletContext = session.getServletContext();
            //获取项目的根路径
            String rootPath = servletContext.getRealPath("/");
            File filePath = new File(rootPath, "/uploadfiles");
            if (!filePath.exists()) {
                filePath.mkdir();//创建上传文件的存储目录
            }
            //重命名上传之后的文件名(唯一)
            String newFileName = IDUtils.genImageName() + originalFilename;
            File file = new File(filePath, newFileName);
            try {
                p.transferTo(file); //执行上传
            } catch (IOException e) {
                e.printStackTrace();
            }
            //封装上传的数据
            Expimage expimage = new Expimage();
            expimage.setFiletype(fileType);
            expimage.setRealname(originalFilename);
            expimage.setFilename(filePath.getName() + "/" + newFileName);
            expimage.setExpid((int) expid);
            expimages.add(expimage);
        }
        System.out.println(expimages);
        //把数据写入数据库
        int n = expService.addExpense(exp, expenseitems, expimages);
        if (n == 1) {
            return "提交成功";
        }
        return "提交失败";
    }

    /**
     * 显示所有的需要审核的报销单
     */
    @RequestMapping("/showToAudit")
    public String showToAudit(HttpSession session, Model model) {
        Employee emp = (Employee) session.getAttribute("emp");
        String empid = emp.getEmpid();
        List<Expense> expenses = expService.selectExpByAudit(empid);
        model.addAttribute("expenses", expenses);
        return "toAudit";
    }

    /**
     * 显示报销的明细项目
     */
    @RequestMapping("/showExpenseDetail/{expid}")
    public String showExpenseDetail(@PathVariable int expid, Model model) {
        List<Expenseitem> expenseitems = expService.findExpItem(expid);
        model.addAttribute("expenseitems", expenseitems);
        return "expenseDetail";
    }

    @RequestMapping("/showExpenseImg/{expid}")
    public String showExpenseImg(@PathVariable int expid, Model m) {
        List<Expimage> expimages = expService.findExpImg(expid);
        m.addAttribute("images", expimages);
        return "expenseImg";
    }

    /**
     * 审核
     *
     * @param expid     要审核的报销单的id
     * @param result    审核的结果码 1 通过,2,决绝,3驳回
     * @param auditdesc 审核的意见
     * @return
     */
    @RequestMapping("/exp/auditing")
    @ResponseBody
    public String auditing(int expid, String result, String auditdesc, HttpSession session) {
        Employee employee = (Employee) session.getAttribute("emp");
        //审核人的id
        String empid = employee.getEmpid();
        Auditing auditing = new Auditing();
        auditing.setEmpid(empid);
        auditing.setAuditdesc(auditdesc);
        auditing.setExpid(expid);
        auditing.setResult(result);
        auditing.setTime(new Date());
        try {
            expService.auditing(auditing);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";//失败
        }

    }

    /**
     * 查报销单的审核记录
     */
    @RequestMapping("/showAuditHistory/{expid}")
    public String showAuditHistory(@PathVariable int expid, Model model) {
        List<Auditing> auditings = expService.findExpenseHistory(expid);
        model.addAttribute("auditings", auditings);
        return "auditHistory";
    }

    /**
     * 显示我的报销
     */
    @RequestMapping("/showMyExpense")
    public String showMyExpense(HttpSession session, Model model) {
        //拿到登陆者的身份
        Employee emp = (Employee) session.getAttribute("emp");
        String empid = emp.getEmpid();
        List<Expense> expenses = expService.selectExpenseById(empid);
        model.addAttribute("expense", expenses);
        return "myAudit";
    }

    /**
     * 查询审核历史
     *
     * @return
     */
    @RequestMapping("/showMyAudit")
    public String showMyAudit(HttpSession session, Model model) {
        //获取当前登录者的身份信息
        Employee emp = (Employee) session.getAttribute("emp");
        String empid = emp.getEmpid();
        List<Auditing> auditings = expService.selectAuditingById(empid);
        model.addAttribute("auditings", auditings);
        return "myAuditHistory";
    }
}



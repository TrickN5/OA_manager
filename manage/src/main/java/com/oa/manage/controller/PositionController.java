package com.oa.manage.controller;


import com.oa.manage.service.PositionService;
import com.oa.pojo.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Map;

@Controller
public class PositionController {

    @Autowired
    PositionService positionService;

    @RequestMapping(value = "/addPosition", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addDept(Position position) {
        int i = positionService.addPosition(position);
        if (i == 1) {
            return "岗位添加成功";
        }
        return "岗位添加失败";
    }

    /**
     * 校验
     */
    @RequestMapping(value = "/checkPositionNo", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String checkPositionNo(int posid) {
        System.out.println("posid:" + posid);
        //查数据库核对DeptNo是否存在
        Position position = positionService.checkPositionNo(posid);
        if (position != null) {
            return "岗位已存在";
        }
        return "可以用";
    }

    /**
     * 校验
     */
    @RequestMapping(value = "/checkPositionName", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String checkPositionName(String pname) {
        System.out.println("pname:" + pname);
        //查数据库核对DeptNo是否存在
        Position position = positionService.checkPositionName(pname);
        if (position != null) {
            return "岗位名称已存在";
        }
        return "可以用";
    }

    /**
     * 显示所有岗位
     */
    @RequestMapping("/showPositionList")
    public String showDeptList(Model model) {
        //从数据库中查询所有的部门数据
        Map<String, Object> map = positionService.selectAllPositions(1, 3);
        System.out.println(map);
        long total = positionService.getTotal();
        System.out.println(map.get("positions"));
        model.addAttribute("positions", map.get("positions"));
        model.addAttribute("pageNum", map.get("pageNum"));
        model.addAttribute("total", total);
        return "positionList";
    }

    int pageNum = 1;

    /**
     * 换页
     */
    @RequestMapping("/dumpTop/{pageNum}")
    public String dumpTo(@PathVariable int pageNum, Model model) {
        this.pageNum = pageNum;
        //从数据库中查询所有的部门数据
        Map<String, Object> map = positionService.selectAllPositions(pageNum, 3);
        long total = positionService.getTotal();
        model.addAttribute("positions", map.get("positions"));
        model.addAttribute("pageNum", map.get("pageNum"));
        model.addAttribute("total", total);
        return "positionList";
    }

    /**
     * 上一页
     *
     * @return
     */
    @RequestMapping("/dumpToPrep")
    public String dumpToPre(Model model) {
        --pageNum;
        //避免页码进入负数
        if (this.pageNum <= 1) {
            this.pageNum = 1;
        }
        //从数据库中查询所有的部门数据
        Map<String, Object> map = positionService.selectAllPositions(pageNum, 3);
        long total = positionService.getTotal();
        model.addAttribute("positions", map.get("positions"));
        model.addAttribute("pageNum", map.get("pageNum"));
        model.addAttribute("total", total);
        return "positionList";
    }

    /**
     * 下一页
     *
     * @return
     */
    @RequestMapping("/dumpToNextp")
    public String dumpToNext(Model model) {
        //从数据库中查询所有的部门数据
        Map<String, Object> map = positionService.selectAllPositions(++pageNum, 3);
        long total = positionService.getTotal();
        model.addAttribute("positions", map.get("positions"));
        model.addAttribute("pageNum", map.get("pageNum"));
        model.addAttribute("total", total);
        return "positionList";
    }


    /**
     * 修改
     */
    @RequestMapping("/updatePosition")
    @ResponseBody
    public String updatePosition(Position position) {
        System.out.println(position);
        //访问数据库，修改数据
        int n = positionService.updatePosition(position);
        if (n == 1) {
            return "修改成功";
        }
        return "修改失败!";
    }

    /**
     * 删除
     */
    @RequestMapping("/deletePosition/{posid}")
    @ResponseBody
    public String deletePosition(@PathVariable int posid) {
        int n = 0;
        try {
            n = positionService.deletePositionByNo(posid);
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            return "当前存在关联关系，无法删除";
        }
        if (n == 1) {
            return "删除成功";
        }
        return "删除失败";
    }
}


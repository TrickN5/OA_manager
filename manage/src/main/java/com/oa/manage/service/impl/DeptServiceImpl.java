package com.oa.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oa.manage.service.DeptService;
import com.oa.mapper.DeptMapper;
import com.oa.pojo.Dept;
import com.oa.pojo.DeptExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public int addDept(Dept dept) {
        int n = deptMapper.insert(dept);
        return n;
    }

    @Override
    public Dept checkDeptNo(int deptno) {
        Dept dept = deptMapper.selectByPrimaryKey(deptno);
        return dept;
    }

    @Override
    public Dept checkDeptName(String deptname) {
        DeptExample exp = new DeptExample();
        exp.createCriteria().andDeptnameEqualTo(deptname);
        List<Dept> depts = deptMapper.selectByExample(exp);
        if (depts != null && depts.size() == 1) {
            return depts.get(0);
        }
        return null;
    }

    /**
     * @param page 当前页码
     * @param rows 显示的行数
     * @return
     */
    @Override
    public Map<String, Object> selectAllDepts(int page, int rows) {
        //使用分页
        PageHelper.startPage(page, rows);
        List<Dept> depts = deptMapper.selectByExample(null);
        PageInfo<Dept> info = new PageInfo<>(depts);
        //当前页码
        int pageNum = info.getPageNum();
        Map<String, Object> map = new HashMap<>();
        map.put("pageNum", pageNum);
        map.put("depts", info.getList());
        return map;
    }

    @Override
    public long getTotal() {
        long l = deptMapper.countByExample(null);
        return l;
    }

    @Override
    public int updateDept(Dept dept) {
        return deptMapper.updateByPrimaryKey(dept);
    }

    /*
    异常手动抛出，给调用者处理
     */
    @Override
    public int deleteDeptByNo(int deptno) throws SQLIntegrityConstraintViolationException {
        int n;
        try {
            n = deptMapper.deleteByPrimaryKey(deptno);
        } catch (Exception e) {
            throw new SQLIntegrityConstraintViolationException("有外键");
        }
        return n;
    }
}

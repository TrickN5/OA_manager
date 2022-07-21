package com.oa.manage.service;

import com.oa.pojo.Dept;

import java.sql.SQLIntegrityConstraintViolationException;

import java.util.Map;

public interface DeptService {
    int addDept(Dept dept);

    Dept checkDeptNo(int deptno);

    Dept checkDeptName(String deptname);

    Map<String, Object> selectAllDepts(int page, int rows);

    long getTotal();

    int updateDept(Dept dept);

    int deleteDeptByNo(int deptno) throws SQLIntegrityConstraintViolationException;
}

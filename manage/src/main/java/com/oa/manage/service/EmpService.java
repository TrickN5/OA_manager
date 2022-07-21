package com.oa.manage.service;

import com.oa.pojo.*;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;


public interface EmpService {


    List<Dept> selectAllDept();


    List<Employee> selectAllMgr();


    List<Position> selectAllPos();

    int addEmployee(Employee emp);

    List<Employee> selectAllEmp();

    List<Employee> MultyFind(String empid, int deptno, int onduty, String hiredate);

    Employee selectEmpById(String empid);

    int updateEmployee(Employee emp);

    int deleteEmpByNo(String empid) throws SQLIntegrityConstraintViolationException;

    String updatePassword(Employee employee);
}

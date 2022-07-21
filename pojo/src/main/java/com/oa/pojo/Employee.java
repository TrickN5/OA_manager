package com.oa.pojo;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
    private String empid;

    private String password;

    private Integer deptno;

    private Integer posid;

    private String mgrid;

    private String realname;

    private String sex;

    private Date birthdate;

    private Date hiredate;

    private Date leavedate;

    private Integer onduty;

    private Integer emptype;

    private String phone;

    private String qq;

    private String emercontactperson;

    private String idcard;

    private Integer rid;
    private Dept dept;
    private Position position;
    private String sHiredate;

    private String sBirthdate;
    private String sLeavedate;

    public String getsBirthdate() {
        return sBirthdate;
    }

    public void setsBirthdate(String sBirthdate) {
        this.sBirthdate = sBirthdate;
    }

    public String getsLeavedate() {
        return sLeavedate;
    }

    public void setsLeavedate(String sLeavedate) {
        this.sLeavedate = sLeavedate;
    }

    private Employee mgr;

    public Employee getMgr() {
        return mgr;
    }

    public void setMgr(Employee mgr) {
        this.mgr = mgr;
    }

    public String getsHiredate() {
        return sHiredate;
    }

    public void setsHiredate(String sHiredate) {
        this.sHiredate = sHiredate;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    private static final long serialVersionUID = 1L;

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid == null ? null : empid.trim();
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(String password) {
        this.password = password == null ? null : password.trim();
        return password;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public Integer getPosid() {
        return posid;
    }

    public void setPosid(Integer posid) {
        this.posid = posid;
    }

    public String getMgrid() {
        return mgrid;
    }

    public void setMgrid(String mgrid) {
        this.mgrid = mgrid == null ? null : mgrid.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Date getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    public Integer getOnduty() {
        return onduty;
    }

    public void setOnduty(Integer onduty) {
        this.onduty = onduty;
    }

    public Integer getEmptype() {
        return emptype;
    }

    public void setEmptype(Integer emptype) {
        this.emptype = emptype;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getEmercontactperson() {
        return emercontactperson;
    }

    public void setEmercontactperson(String emercontactperson) {
        this.emercontactperson = emercontactperson == null ? null : emercontactperson.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid='" + empid + '\'' +
                ", password='" + password + '\'' +
                ", deptno=" + deptno +
                ", posid=" + posid +
                ", mgrid='" + mgrid + '\'' +
                ", realname='" + realname + '\'' +
                ", sex='" + sex + '\'' +
                ", birthdate=" + birthdate +
                ", hiredate=" + hiredate +
                ", leavedate=" + leavedate +
                ", onduty=" + onduty +
                ", emptype=" + emptype +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", emercontactperson='" + emercontactperson + '\'' +
                ", idcard='" + idcard + '\'' +
                ", rid=" + rid +
                ", dept=" + dept +
                ", position=" + position +
                '}';
    }
}
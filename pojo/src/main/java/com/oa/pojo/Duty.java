package com.oa.pojo;

import java.io.Serializable;
import java.util.Date;

public class Duty implements Serializable {
    private Integer dtid;

    private String emprid;

    private Date dtdate;


    private String sdtdate; //年-月-日格式

    private String signintime;

    private String signouttime;
    private Employee employee;
    private Dept dept;

    public String getSdtdate() {
        return sdtdate;
    }

    public void setSdtdate(String sdtdate) {
        this.sdtdate = sdtdate;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    private static final long serialVersionUID = 1L;

    public Integer getDtid() {
        return dtid;
    }

    public void setDtid(Integer dtid) {
        this.dtid = dtid;
    }

    public String getEmprid() {
        return emprid;
    }

    public void setEmprid(String emprid) {
        this.emprid = emprid == null ? null : emprid.trim();
    }

    public Date getDtdate() {
        return dtdate;
    }

    public void setDtdate(Date dtdate) {
        this.dtdate = dtdate;
    }

    public String getSignintime() {
        return signintime;
    }

    public void setSignintime(String signintime) {
        this.signintime = signintime == null ? null : signintime.trim();
    }

    public String getSignouttime() {
        return signouttime;
    }

    public void setSignouttime(String signouttime) {
        this.signouttime = signouttime == null ? null : signouttime.trim();
    }

    @Override
    public String toString() {
        return "Duty{" +
                "dtid=" + dtid +
                ", emprid='" + emprid + '\'' +
                ", dtdate=" + dtdate +
                ", signintime='" + signintime + '\'' +
                ", signouttime='" + signouttime + '\'' +
                ", employee=" + employee +
                ", dept=" + dept +
                '}';
    }
}
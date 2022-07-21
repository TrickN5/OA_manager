package com.oa.pojo;

import java.io.Serializable;
import java.util.Date;

public class Expense implements Serializable {
    private Integer expid;

    private String empid;

    private Double totalamount;

    private Date exptime;
    private String sexptime;
    private String expdesc;

    private String nextauditor;

    private String lastresult;

    private String status;

    private Employee employee;
    private String nextauditorName;

    private Auditing auditing;

    public void setAuditing(Auditing auditing) {
        this.auditing = auditing;
    }

    public Auditing getAuditing() {
        return auditing;
    }

    public String getNextauditorName() {
        return nextauditorName;
    }

    public void setNextauditorName(String nextauditorName) {
        this.nextauditorName = nextauditorName;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getSexptime() {
        return sexptime;
    }

    public Expense setSexptime(String sexptime) {
        this.sexptime = sexptime;
        return null;
    }


    private static final long serialVersionUID = 1L;

    public Integer getExpid() {
        return expid;
    }

    public void setExpid(Integer expid) {
        this.expid = expid;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid == null ? null : empid.trim();
    }

    public Double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
    }

    public Date getExptime() {
        return exptime;
    }

    public void setExptime(Date exptime) {
        this.exptime = exptime;
    }

    public String getExpdesc() {
        return expdesc;
    }

    public void setExpdesc(String expdesc) {
        this.expdesc = expdesc == null ? null : expdesc.trim();
    }

    public String getNextauditor() {
        return nextauditor;
    }

    public void setNextauditor(String nextauditor) {
        this.nextauditor = nextauditor == null ? null : nextauditor.trim();
    }

    public String getLastresult() {
        return lastresult;
    }

    public void setLastresult(String lastresult) {
        this.lastresult = lastresult == null ? null : lastresult.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expid=" + expid +
                ", empid='" + empid + '\'' +
                ", totalamount=" + totalamount +
                ", exptime=" + exptime +
                ", sexptime='" + sexptime + '\'' +
                ", expdesc='" + expdesc + '\'' +
                ", nextauditor='" + nextauditor + '\'' +
                ", lastresult='" + lastresult + '\'' +
                ", status='" + status + '\'' +
                ", employee=" + employee +
                '}';
    }
}
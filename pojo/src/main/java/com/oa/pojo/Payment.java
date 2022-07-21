package com.oa.pojo;

import java.io.Serializable;
import java.util.Date;

public class Payment implements Serializable {
    private Integer pid;

    private String payempid;

    private Double amount;

    private Date paytime;

    private Integer expid;

    private String empid;

    private static final long serialVersionUID = 1L;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPayempid() {
        return payempid;
    }

    public void setPayempid(String payempid) {
        this.payempid = payempid == null ? null : payempid.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pid=").append(pid);
        sb.append(", payempid=").append(payempid);
        sb.append(", amount=").append(amount);
        sb.append(", paytime=").append(paytime);
        sb.append(", expid=").append(expid);
        sb.append(", empid=").append(empid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.oa.pojo;

import java.io.Serializable;
import java.util.Date;

public class Income implements Serializable {
    private Integer icid;

    private Integer amount;

    private Date icdate;

    private String ictype;

    private String indesc;

    private String userid;
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    private static final long serialVersionUID = 1L;

    public Integer getIcid() {
        return icid;
    }

    public void setIcid(Integer icid) {
        this.icid = icid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getIcdate() {
        return icdate;
    }

    public void setIcdate(Date icdate) {
        this.icdate = icdate;
    }

    public String getIctype() {
        return ictype;
    }

    public void setIctype(String ictype) {
        this.ictype = ictype == null ? null : ictype.trim();
    }

    public String getIndesc() {
        return indesc;
    }

    public void setIndesc(String indesc) {
        this.indesc = indesc == null ? null : indesc.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", icid=").append(icid);
        sb.append(", amount=").append(amount);
        sb.append(", icdate=").append(icdate);
        sb.append(", ictype=").append(ictype);
        sb.append(", indesc=").append(indesc);
        sb.append(", userid=").append(userid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
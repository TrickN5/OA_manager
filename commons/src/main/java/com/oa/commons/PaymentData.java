package com.oa.commons;

public class PaymentData {
    private String expid;
    private String totalamout;

    public String getExpid() {
        return expid;
    }

    public void setExpid(String expid) {
        this.expid = expid;
    }

    public String getTotalamout() {
        return totalamout;
    }

    public void setTotalamout(String totalamout) {
        this.totalamout = totalamout;
    }

    @Override
    public String toString() {
        return "PaymentData{" +
                "expid='" + expid + '\'' +
                ", totalamout='" + totalamout + '\'' +
                '}';
    }
}
package com.oa.commons;

public class IncomeData {
    private String indesc;
    private String totalmount;

    public String getIndesc() {
        return indesc;
    }

    public void setIndesc(String indesc) {
        this.indesc = indesc;
    }

    public String getTotalmount() {
        return totalmount;
    }

    public void setTotalmount(String totalmount) {
        this.totalmount = totalmount;
    }

    @Override
    public String toString() {
        return "IncomeData{" +
                "indesc='" + indesc + '\'' +
                ", totalmount='" + totalmount + '\'' +
                '}';
    }
}

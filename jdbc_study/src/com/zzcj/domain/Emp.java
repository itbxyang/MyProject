package com.zzcj.domain;

import java.util.Date;

public class Emp {

    private Integer id;

    private String ename;

    private String job;

    private Date hiredate;

    private Double sal;

    public Emp() {
    }

    public Emp(Integer id, String ename, String job, Date hiredate, Double sal) {
        this.id = id;
        this.ename = ename;
        this.job = job;
        this.hiredate = hiredate;
        this.sal = sal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                '}';
    }
}

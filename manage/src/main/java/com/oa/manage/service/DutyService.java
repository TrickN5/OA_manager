package com.oa.manage.service;

import com.oa.pojo.Duty;

import java.util.List;

public interface DutyService {

    Duty findDuty(java.sql.Date date, String empid);


    int addDutyData(Duty duty1);

    int updateDuty(Duty duty1);

    String findAll();

    List<Duty> findAllDuty();
}

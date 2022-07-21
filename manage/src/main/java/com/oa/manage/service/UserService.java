package com.oa.manage.service;

import com.oa.pojo.Employee;


public interface UserService {

     Employee loginUser(Employee employee);

    Employee selectByPhone(String phone);
}

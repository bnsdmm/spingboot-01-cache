package com.atguigu.cache.service;

import com.atguigu.cache.bean.Employee;
import com.atguigu.cache.mapper.EmployeeMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = {"emp"}/*keyGenerator = "myKeyGenerator"*/)
    public Employee getEmp(Integer id) {
        Employee employee = employeeMapper.getEmpById(id);
        return employee;
    }

    @CachePut(cacheNames = {"emp"}, key = "#result.id")
    public Employee updateEmp(Employee employee) {
        employeeMapper.updataEmp(employee);
        return employee;
    }

    @CacheEvict(value = {"emp"},key = "#id")
    public void deleteEmp(Integer id) {
        employeeMapper.deleteEmpById(id);
    }
}

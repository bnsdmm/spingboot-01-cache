package com.atguigu.cache.service;

import com.atguigu.cache.bean.Department;
import com.atguigu.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = {"dept"}, cacheManager = "deptCacheManager")
@Service
public class DeptService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Qualifier("deptCacheManager")
    @Autowired
    CacheManager deptCacheManager;

    //1.使用注解的方式
    /*@Cacheable(*//*cacheNames = "dept"*//*)
    public Department getDeptById(Integer id) {
        System.out.println("部门查询" + id);
        Department department = departmentMapper.getDeptById(id);
        return department;
    }*/
    //使用编码的方式
    public Department getDeptById(Integer id) {
        Department department = departmentMapper.getDeptById(id);
        Cache cache = deptCacheManager.getCache("dept");
        cache.put("dept:2", department);
        return department;
    }
}

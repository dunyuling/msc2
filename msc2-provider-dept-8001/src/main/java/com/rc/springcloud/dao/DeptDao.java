package com.rc.springcloud.dao;

import com.rc.springcloud.entity.Dept;

import java.util.List;

/**
 * @ClassName DeptDao
 * @Description
 * @Author liux
 * @Date 19-7-31 下午5:27
 * @Version 1.0
 */
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();
}

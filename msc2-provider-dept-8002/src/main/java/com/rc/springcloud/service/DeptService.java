package com.rc.springcloud.service;

import com.rc.springcloud.entity.Dept;

import java.util.List;

/**
 * @ClassName DeptService
 * @Description
 * @Author liux
 * @Date 19-8-1 上午10:10
 * @Version 1.0
 */
public interface DeptService {

    public boolean add(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();
}

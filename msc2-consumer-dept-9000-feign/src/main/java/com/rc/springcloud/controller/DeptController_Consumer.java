package com.rc.springcloud.controller;

import com.rc.springcloud.entity.Dept;
import com.rc.springcloud.response.DeptResponse;
import com.rc.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName DeptController_Consumer
 * @Description 通过DeptClientService接口声明本身可以实现服务端的http调用
 * @Author liux
 * @Date 19-8-1 下午12:18
 * @Version 1.0
 */
@RestController
@RequestMapping("/consumer")
public class DeptController_Consumer {

    @Autowired
    private DeptClientService deptClientService;

    @GetMapping("/dept/list1")
    public List<Dept> list1() {
        return deptClientService.list1();
    }

    @GetMapping("/dept/list2")
    public DeptResponse list2() {
        return deptClientService.list2();
    }

    @GetMapping("/dept/{id}")
    public Dept get(@PathVariable long id) {
        return deptClientService.get(id);
    }
}
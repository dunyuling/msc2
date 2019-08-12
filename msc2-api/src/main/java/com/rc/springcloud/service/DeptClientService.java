package com.rc.springcloud.service;

//import com.rc.fallback.DeptClientServiceFallbackFactory;

import com.rc.springcloud.entity.Dept;
import com.rc.springcloud.response.DeptResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @ClassName DeptClientService
 * @Description 使用该类可以直接通过http方式访问服务端的相应api, 类似于mybatis的mapper接口声明
 * @Author liux
 * @Date 19-8-7 下午2:29
 * @Version 1.0
 */
//1.普通情况下的用法
//@FeignClient(value = "MICROSERVICECLOUD-DEPT") //设置将要使用的微服务名称

//2.提供服务降级情况下的用法
@FeignClient(value = "MICROSERVICECLOUD-DEPT",//设置将要使用的微服务名称
        fallbackFactory = DeptClientServiceFallbackFactory.class) //设置出错时的熔断处理类
public interface DeptClientService {

    @GetMapping("/dept/list1")
    List<Dept> list1();

    @GetMapping("/dept/list2")
    DeptResponse list2();

    @GetMapping("/dept/{id}")
    Dept get(@PathVariable("id") Long id);
}

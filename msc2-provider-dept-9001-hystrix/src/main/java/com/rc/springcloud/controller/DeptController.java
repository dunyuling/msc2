package com.rc.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rc.springcloud.entity.Dept;
import com.rc.springcloud.response.DeptResponse;
import com.rc.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DeptController
 * @Description
 * @Author liux
 * @Date 19-7-31 下午5:42
 * @Version 1.0
 */
@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @Autowired
    DiscoveryClient discoveryClient;


    @PostMapping("/dept/add")
    public void add(Dept dept) {
        deptService.add(dept);
    }

    //TODO 访问表中不存在的id,将会调用'processHystrix_Get'方法
    @GetMapping("/dept/{id}")
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable Long id) {
        Dept dept = deptService.get(id);
        if (null == dept) {
            throw new RuntimeException("该Id: " + id + "没有对应的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable Long id) {
        return new Dept().setDeptno(id).setDname("该Id: " + id + "没有对应信息,null-@HystrixCommand")
                .setDbSource("no this database in MySQL");
    }

    @GetMapping("/dept/list1")
    @HystrixCommand(fallbackMethod = "processHystrix_List1")
    public List<Dept> list1() {
        return deptService.list();
    }

    public List<Dept> processHystrix_List1() {
        List<Dept> list = new ArrayList<>();
        list.add(new Dept().setDeptno(0L).setDname("空列表-processHystrix_List1-@HystrixCommand")
                .setDbSource("no this database in MySQL"));
        return list;
    }

    @GetMapping("/dept/list2")
    @HystrixCommand(fallbackMethod = "processHystrix_List2")
    public DeptResponse list2() {
        List<Dept> list = deptService.list();
        return new DeptResponse(list);
    }

    public DeptResponse processHystrix_List2() {
        List<Dept> list = new ArrayList<>();
        list.add(new Dept().setDeptno(0L).setDname("空列表-processHystrix_List2-@HystrixCommand")
                .setDbSource("no this database in MySQL"));
        DeptResponse deptResponse = new DeptResponse();
        deptResponse.setList(list);
        return deptResponse;
    }

    @GetMapping("/dept/discovery")
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("---------------" + list);

        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance instance : serviceInstances) {
            System.out.println(instance.getServiceId()
                    + "\t" + instance.getHost()
                    + "\t" + instance.getPort()
                    + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
}

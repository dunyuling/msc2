package com.rc.springcloud.controller;

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

import java.util.List;

/**
 * @ClassName DeptController
 * @Description TODO
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

    @GetMapping("/dept/{id}")
    public Dept get(@PathVariable Long id) {
        return deptService.get(id);
    }

    @GetMapping("/dept/list1")
    public List<Dept> list1() {
        return deptService.list();
    }

    @GetMapping("/dept/list2")
    public DeptResponse list2() {
        List<Dept> list = deptService.list();
        return new DeptResponse(list);
    }

    @GetMapping("/dept/discovery")
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("---------------" + list);

        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("MICROSERVICECLOUD-CONFIG-DEPT-CLIENT");
        for (ServiceInstance instance : serviceInstances) {
            System.out.println(instance.getServiceId()
                    + "\t" + instance.getHost()
                    + "\t" + instance.getPort()
                    + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
}

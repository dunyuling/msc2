package com.rc.springcloud.controller;

import com.rc.springcloud.entity.Dept;
import com.rc.springcloud.response.DeptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @ClassName DeptController_Consumer
 * @Description TODO
 * @Author liux
 * @Date 19-8-1 下午12:18
 * @Version 1.0
 */
@RestController
@RequestMapping("/consumer")
public class DeptController_Consumer {

    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/dept/list1")
    public List<Dept> list1() {
        String url = REST_URL_PREFIX + "/dept/list1";
        return (List<Dept>) restTemplate.getForObject(url, List.class);
    }

    @GetMapping("/dept/list2")
    public DeptResponse list2() {
        String url = REST_URL_PREFIX + "/dept/list2";
        DeptResponse response = restTemplate.getForEntity(url, DeptResponse.class).getBody();
        System.out.println("response: " + response);
        return response;
    }

    @GetMapping("/dept/{id}")
    public Dept get(@PathVariable Long id) {
        String url = REST_URL_PREFIX + "/dept/" + id;
        return restTemplate.getForEntity(url, Dept.class).getBody();
    }

    @RequestMapping("/dept/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }
}
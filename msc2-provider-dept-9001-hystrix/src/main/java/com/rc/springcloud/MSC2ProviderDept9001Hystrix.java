package com.rc.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@EnableHystrix  //TODO 跟@EnableCircuitBreaker 有什么区别
@EnableCircuitBreaker //对hystrix 熔断机制的支持
@EnableDiscoveryClient //服务发现
@EnableEurekaClient //本服务启动后会自动注入eureka 服务中
@MapperScan(basePackages = "com.rc.springcloud.dao")//扫描mybatis mapper
@SpringBootApplication
public class MSC2ProviderDept9001Hystrix {
    public static void main(String[] args) {
        SpringApplication.run(MSC2ProviderDept9001Hystrix.class, args);
    }
}
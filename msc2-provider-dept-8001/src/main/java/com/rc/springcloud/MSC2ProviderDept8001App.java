package com.rc.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan(basePackages = "com.rc.springcloud.dao")
@SpringBootApplication
public class MSC2ProviderDept8001App {

    public static void main(String[] args) {
        SpringApplication.run(MSC2ProviderDept8001App.class, args);
    }


}

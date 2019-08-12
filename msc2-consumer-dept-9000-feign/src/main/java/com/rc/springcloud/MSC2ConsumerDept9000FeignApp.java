package com.rc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients(basePackages = "com.rc.springcloud")
@SpringBootApplication(scanBasePackages = "com.rc.springcloud")
public class MSC2ConsumerDept9000FeignApp {

    public static void main(String[] args) {
        SpringApplication.run(MSC2ConsumerDept9000FeignApp.class, args);
    }

}

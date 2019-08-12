package com.rc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MSC2Eureka7002App {

    public static void main(String[] args) {
        SpringApplication.run(MSC2Eureka7002App.class, args);
    }

}

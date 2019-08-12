package com.rc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class MSC2Hystrix10000DashboardApp {

    public static void main(String[] args) {
        SpringApplication.run(MSC2Hystrix10000DashboardApp.class, args);
    }
}
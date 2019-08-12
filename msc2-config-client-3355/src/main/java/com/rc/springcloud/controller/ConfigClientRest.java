package com.rc.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigClientRest
 * @Description
 * @Author liux
 * @Date 19-8-8 下午6:14
 * @Version 1.0
 */
@RestController
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    private String config() {
        String config = "ConfigClientRest{" +
                "applicationName='" + applicationName + '\'' +
                ", eurekaServers='" + eurekaServers + '\'' +
                ", port='" + port + '\'' +
                '}';
        System.out.println(config);
        return config;
    }
}
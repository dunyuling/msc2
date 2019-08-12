package com.rc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MSC2ConfigServer3344App {

    public static void main(String[] args) {
        SpringApplication.run(MSC2ConfigServer3344App.class, args);
    }

}

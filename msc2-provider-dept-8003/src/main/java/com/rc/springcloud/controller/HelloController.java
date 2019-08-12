package com.rc.springcloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName HelloController
 * @Description 为了测试服务器能够承受的并发数, 结合jmeter进行测试
 * @Author liux
 * @Date 19-8-9 下午5:58
 * @Version 1.0
 */
@RestController
public class HelloController {

    private AtomicInteger atomicInteger = new AtomicInteger();

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        System.out.println("序号: " + atomicInteger.incrementAndGet());
        return ResponseEntity.ok("Hello");
    }
}

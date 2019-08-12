package com.rc.springcloud.cfgbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ConfigBean
 * @Description 配置类---Ribbon 负载均衡在这里生效
 * @Author liux
 * @Date 19-8-1 下午12:12
 * @Version 1.0
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced //Ribbon load balance,很好的设计,直接在请求处实现负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /*@Bean //默认使用轮询算法,这里使用随机算法替换轮询算法
    public IRule myRuler() {
//        return new RandomRule();//默认使用轮询算法,这里使用随机算法替换轮询算法
        return new RetryRule();
    }*/


}

package com.rc.springcloud.myruler;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyRibbonRule
 * @Description 自定义ribbon 负载均衡策略配置类
 * @Author liux
 * @Date 19-8-7 上午11:29
 * @Version 1.0
 */

@Configuration
public class MyRibbonRule {
    @Bean //默认使用轮询算法,这里使用随机算法替换轮询算法
    public IRule myRuler() {
//        return new RandomRule();//默认使用轮询算法,这里使用随机算法替换轮询算法
//        return new RandomRule();
        return new MyRoundRuler();
    }

}
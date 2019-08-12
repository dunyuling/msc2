package com.rc.springcloud;

import com.rc.springcloud.myruler.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @ClassName MSC2ConsumerDept8111App_Ribbon
 * @Description 客户端主启动类
 * @Author liux
 * @Date 19-8-1 下午12:25
 * @Version 1.0
 */
@EnableEurekaClient
@SpringBootApplication
//在启动微服务的时候就去加载我们自定义Ribbon配置类,从而使配置生效
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration = MyRibbonRule.class)
public class MSC2ConsumerDept8111App_Ribbon {

    public static void main(String[] args) {
        SpringApplication.run(MSC2ConsumerDept8111App_Ribbon.class, args);
    }
}

### 基于springcloud的微服务示例项目.
### 包含以下功能:
    + 注册中心包含以下三个模块.注册中心可以单独使用,为了保证高可用实现了集群功能
        * msc2-eureka-7001
        * msc2-eureka-7002
        * msc2-eureka-7003
    + 基本服务-包含以下三个模块,通过注册中心实现了高可用(即同时开启下面三个服务中的至少两个)
        * msc2-provider-dept-8001
        * msc2-provider-dept-8002
        * msc2-provider-dept-8003
    + 基本客户端
        * msc2-consumer-dept-8000
            
    + 负载均衡ribbon,包含以下模块,结合eureka集群和高可用的provider-dept服务可做测试
        * msc2-consumer-dept-8111-ribbon
    +  feign
        * 对应模块 msc2-consumer-dept-9000-feign
        * 可以实现负载均衡,类似ribbon
        * feign 可以结合hystrix实现调用端(消费端)的服务降级
    + hystrix
        * 对应模块 msc2-provider-dept-9001-hystrix
        * 可以实现被调用端(服务端)的熔断服务
    + hystrix-dashboard
        * 对应模块 msc2-consumer-10000-hystrix-dashboard
        * 可以可视化观察 访问msc2-provider-dept-9001-hystrix 服务中相应方法的请求情况
    + zuul
        * 对应模块 msc2-zuul-gateway-9527 
        * 实现路由功能,配合注册中心共同工作,位于服务端前面
    + config
        + 对应模块
            * 服务端 msc2-config-server-3344
            + 客户端
                * msc2-config-client-3355
                * msc2-config-client-provider-dept-8001
                * msc2-config-client-eureka-7001
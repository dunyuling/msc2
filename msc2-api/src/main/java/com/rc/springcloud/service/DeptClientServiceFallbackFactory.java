package com.rc.springcloud.service;

import com.rc.springcloud.entity.Dept;
import com.rc.springcloud.response.DeptResponse;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName DeptClientServiceFallbackFactory
 * @Description 服务降级 Fallback处理类
 * @Author liux
 * @Date 19-8-7 下午7:22
 * @Version 1.0
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable cause) {
        return new DeptClientService() {
            @Override
            public List<Dept> list1() {
                return null;
            }

            @Override
            public DeptResponse list2() {
                return null;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("该Id: " + id + "没有对应信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
                        .setDbSource("no this database in MySQL");
            }
        };
    }
}

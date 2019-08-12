package com.rc.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName Dept
 * @Description TODO
 * @Author liux
 * @Date 19-8-1 上午10:36
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable {

    private Long deptno; //主键

    private String dname; //部门名称

    private String dbSource;//来自哪个数据库,因为微服务架构可以一个服务对应一个数据库,同一个信息被存储到不同数据库

    public Dept(String dname) {
        super();
        this.dname = dname;
    }
}
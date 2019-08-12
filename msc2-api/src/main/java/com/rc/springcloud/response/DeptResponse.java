package com.rc.springcloud.response;

import com.rc.springcloud.entity.Dept;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName DeptResponse
 * @Description TODO
 * @Author liux
 * @Date 19-8-1 下午12:21
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeptResponse implements Serializable {

    public List<Dept> list;
}

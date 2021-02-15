package com.imooc.security.core.support;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * description: 简单的返回对象
 * @author Wjh
 * @date 2020/11/9 11:13
 */
@Data
@AllArgsConstructor
public class SimpleResponse {

    /**
     * 响应数据
     */
    private Object data;
}

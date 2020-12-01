package com.imooc.security.core.properties;

import lombok.Data;

/**
 * description: 
 * @author: JiaHao Wang
 * @date: 2020/12/1 12:16
 * @modified By:
 */
@Data
public class ValidateCodeProperties {

    /**
     * 图形验证码
     */
    private ImageCodeProperties image = new ImageCodeProperties();
}

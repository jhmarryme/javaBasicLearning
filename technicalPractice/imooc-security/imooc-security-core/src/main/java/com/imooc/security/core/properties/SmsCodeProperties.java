package com.imooc.security.core.properties;

import lombok.Data;

/**
 * description: 
 * @author: JiaHao Wang
 * @date: 2020/12/3 19:28
 * @modified By:
 */
@Data
public class SmsCodeProperties {

    private int length = 6;

    private int expireIn = 180;

    private String url;
}

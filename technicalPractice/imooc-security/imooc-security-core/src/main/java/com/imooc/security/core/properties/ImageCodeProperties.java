package com.imooc.security.core.properties;

import lombok.Data;

/**
 * description: 
 * @author: JiaHao Wang
 * @date: 2020/12/1 12:17
 * @modified By:
 */
@Data
public class ImageCodeProperties extends SmsCodeProperties{

    private int width = 67;

    private int height = 23;

    public ImageCodeProperties() {
        setLength(4);
    }
}

package com.imooc.code;

import com.imooc.security.core.validate.code.ImageCode;
import com.imooc.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * description: 如果有另外的图形验证码生成方式, 可以在这里实现
 * @author: JiaHao Wang
 * @date: 2020/12/1 17:43
 * @modified By:
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(HttpServletRequest request) {
        System.out.println("另一种生成图形验证码的方式");
        return null;
    }
}

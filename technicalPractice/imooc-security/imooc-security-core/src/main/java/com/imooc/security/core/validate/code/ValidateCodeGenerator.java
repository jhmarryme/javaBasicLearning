package com.imooc.security.core.validate.code;

import javax.servlet.http.HttpServletRequest;

/**
 * description: 验证码生成器
 * @author: JiaHao Wang
 * @date: 2020/12/1 17:23
 * @modified By:
 */
public interface ValidateCodeGenerator {

    /**
     * 生成验证码的逻辑
     * <br/>
     * @param request
     * @return com.imooc.security.core.validate.code.ImageCode
     */
    ImageCode generate(HttpServletRequest request);
}

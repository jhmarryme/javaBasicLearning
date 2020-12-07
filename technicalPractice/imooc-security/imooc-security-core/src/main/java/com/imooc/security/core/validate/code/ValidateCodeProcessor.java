package com.imooc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * description: 校验码处理器，封装不同校验码的处理逻辑
 * @author: JiaHao Wang
 * @date: 2020/12/3 20:19
 * @modified By:
 */
public interface ValidateCodeProcessor {

    String SESSION_KEY_PREFIX = "SESSION_KEY_IMAGE_CODE_";

    /**
     * 创建验证码
     * <br/>
     * @param request
     * @return void
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

}

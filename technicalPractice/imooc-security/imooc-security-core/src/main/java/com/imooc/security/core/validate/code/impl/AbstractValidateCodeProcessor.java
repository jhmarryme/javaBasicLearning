package com.imooc.security.core.validate.code.impl;

import com.imooc.security.core.validate.code.base.ValidateCode;
import com.imooc.security.core.validate.code.ValidateCodeGenerator;
import com.imooc.security.core.validate.code.ValidateCodeProcessor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * description: 
 * @author: JiaHao Wang
 * @date: 2020/12/3 20:19
 * @modified By:
 */
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    /**
     * 通过spring的依赖查找机制, 收集 {@link ValidateCodeGenerator} 接口的所有实现
     */
    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGeneratorMap;

    @Override
    public void create(ServletWebRequest request) throws Exception {
        C validateCode = generate(request);
        save(request, validateCode);
        send(request, validateCode);
    }

    /**
     * 生成校验码
     * <br/>
     * @author Jiahao Wang
     * @date 2020/12/3 20:25
     * @param request
     * @return C
     */
    @SuppressWarnings("unchecked")
    private C generate(ServletWebRequest request) {
        String type = getProcessorType(request);
        ValidateCodeGenerator validateCodeGenerator = validateCodeGeneratorMap.get(type + "CodeGenerator");
        return (C) validateCodeGenerator.generate(request);
    }

    /**
     * 根据请求的url获取验证码的类型
     * <br/>
     * @author Jiahao Wang
     * @date 2020/12/3 20:31
     * @param request
     * @return java.lang.String
     */
    private String getProcessorType(ServletWebRequest request) {
        return StringUtils.substringAfter(request.getRequest().getRequestURI(), "/code/");
    }

    private void save(ServletWebRequest request, C validateCode) {
        sessionStrategy.setAttribute(request, SESSION_KEY_PREFIX, validateCode);
    }

    protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;
}

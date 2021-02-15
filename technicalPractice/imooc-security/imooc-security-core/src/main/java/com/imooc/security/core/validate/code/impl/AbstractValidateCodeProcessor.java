package com.imooc.security.core.validate.code.impl;

import com.imooc.security.core.validate.code.base.ValidateCode;
import com.imooc.security.core.validate.code.ValidateCodeGenerator;
import com.imooc.security.core.validate.code.ValidateCodeProcessor;
import com.imooc.security.core.validate.code.base.ValidateCodeException;
import com.imooc.security.core.validate.code.base.ValidateCodeTypeEnum;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;
import java.util.Optional;

/**
 * description: 
 * @author JiaHao Wang
 * @date 2020/12/3 20:19
 */
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

    /**
     * 操作session的工具类
     */
    private final SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

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

    @SuppressWarnings("unchecked")
    @Override
    public void validate(ServletWebRequest request) {

        ValidateCodeTypeEnum validateCodeType = getValidateCodeType();

        String sessionKey = getSessionKey();

        C codeInSession = (C) sessionStrategy.getAttribute(request, sessionKey);

        String codeInRequest;
        try {
            codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(),
                    validateCodeType.getParamNameOnValidate());
        } catch (ServletRequestBindingException e) {
            throw new ValidateCodeException("从请求中获取验证码失败");
        }

        if (StringUtils.isBlank(codeInRequest)) {
            throw new ValidateCodeException(validateCodeType + "验证码的值不能为空");
        }

        if (codeInSession == null) {
            throw new ValidateCodeException(validateCodeType + "验证码不存在");
        }

        if (codeInSession.isExpired()) {
            sessionStrategy.removeAttribute(request, sessionKey);
            throw new ValidateCodeException(validateCodeType + "验证码已过期");
        }

        if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
            throw new ValidateCodeException(validateCodeType + "验证码不匹配");
        }

        sessionStrategy.removeAttribute(request, sessionKey);
    }

    /**
     * 根据类型的不同 生成校验码
     * <br/>
     * @author Jiahao Wang
     * @date 2020/12/3 20:25
     * @param request
     * @return C
     */
    @SuppressWarnings("unchecked")
    private C generate(ServletWebRequest request) {
        String type = getValidateCodeType().toString().toLowerCase();
        String generateName = type + "CodeGenerator";
        ValidateCodeGenerator validateCodeGenerator =
                Optional.ofNullable(validateCodeGeneratorMap.get(generateName))
                        .orElseThrow(() -> new ValidateCodeException("验证码生成器: " + generateName + "不存在"));
        return (C) validateCodeGenerator.generate(request);
    }

    /**
     * 获取验证码的类型
     * <br/>
     * @author Jiahao Wang
     * @date 2020/12/30 10:43
     * @return com.imooc.security.core.validate.code.base.ValidateCodeTypeEnum
     */
    private ValidateCodeTypeEnum getValidateCodeType() {
        String type = StringUtils.substringBefore(getClass().getSimpleName(), "CodeProcessor");
        return ValidateCodeTypeEnum.valueOf(type.toUpperCase());
    }


    /**
     * 保存校验码到session
     * <br/>
     * @author Jiahao Wang
     * @date 2020/12/30 10:47
     * @param request
     * @param validateCode
     * @return void
     */
    private void save(ServletWebRequest request, C validateCode) {
        ValidateCode code = new ValidateCode(validateCode.getCode(), validateCode.getExpireTime());
        sessionStrategy.setAttribute(request, getSessionKey(), code);
    }

    /**
     * 构建验证码放入session时的key
     * <br/>
     * @author Jiahao Wang
     * @date 2020/12/30 10:46
     * @return java.lang.String
     */
    private String getSessionKey() {
        return SESSION_KEY_PREFIX + getValidateCodeType().toString().toUpperCase();
    }

    /**
     * 发送校验码，由子类实现
     * <br/>
     * @author Jiahao Wang
     * @date 2020/12/30 10:46
     * @param request
     * @param validateCode
     * @return void
     * @throws Exception
     */
    protected abstract void send(ServletWebRequest request, C validateCode) throws Exception;
}

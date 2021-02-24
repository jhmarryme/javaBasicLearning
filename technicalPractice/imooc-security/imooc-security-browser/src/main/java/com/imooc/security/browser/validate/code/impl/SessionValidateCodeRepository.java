package com.imooc.security.browser.validate.code.impl;

import com.imooc.security.core.validate.code.ValidateCodeRepository;
import com.imooc.security.core.validate.code.base.ValidateCode;
import com.imooc.security.core.validate.code.base.ValidateCodeTypeEnum;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Optional;

/**
 * description: 基于session的 验证码存储器
 * @author JiaHao Wang
 * @date 2021/2/23 12:35
 */
public class SessionValidateCodeRepository implements ValidateCodeRepository {

    /**
     * key的前缀
     */
    private static final String SESSION_KEY_PREFIX = "SESSION_KEY_IMAGE_CODE_";

    /**
     * 操作session的工具类
     */
    private final SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    public void save(ServletWebRequest request, ValidateCode code, ValidateCodeTypeEnum validateCodeTypeEnum) {
        sessionStrategy.setAttribute(request, getSessionKey(validateCodeTypeEnum), code);
    }

    @Override
    public Optional<ValidateCode> get(ServletWebRequest request, ValidateCodeTypeEnum validateCodeTypeEnum) {
        Object value = sessionStrategy.getAttribute(request, getSessionKey(validateCodeTypeEnum));
        if (value == null) {
            return Optional.empty();
        }
        return Optional.of((ValidateCode) value);
    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeTypeEnum validateCodeTypeEnum) {
        sessionStrategy.removeAttribute(request, getSessionKey(validateCodeTypeEnum));
    }

    /**
     * 构建验证码放入session时的key
     * <br/>
     * @author Jiahao Wang
     * @date 2020/12/30 10:46
     * @return java.lang.String
     */
    private String getSessionKey(ValidateCodeTypeEnum validateCodeTypeEnum) {
        return SESSION_KEY_PREFIX + validateCodeTypeEnum.toString().toUpperCase();
    }
}

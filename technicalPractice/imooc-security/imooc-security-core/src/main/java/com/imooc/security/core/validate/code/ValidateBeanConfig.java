package com.imooc.security.core.validate.code;

import com.imooc.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description: 验证码相关的Bean配置
 * @author: JiaHao Wang
 * @date: 2020/12/1 17:30
 * @modified By:
 */
@Configuration
public class ValidateBeanConfig {

    /**  
     * 系统配置
     */
    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 当不存在name为imageCodeGenerator的时, 创建一个
     * 如果用户创建了, 则不创建该bean
     * <br/>
     * @author Jiahao Wang
     * @date 2020/12/1 17:57
     * @param  
     * @return com.imooc.security.core.validate.code.ValidateCodeGenerator
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenerator() {
        ImageCodeGenerator imageCodeGenerator = new ImageCodeGenerator();
        imageCodeGenerator.setSecurityProperties(securityProperties);
        return imageCodeGenerator;
    }
}

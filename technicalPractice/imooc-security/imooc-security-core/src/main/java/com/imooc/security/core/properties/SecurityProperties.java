package com.imooc.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * description: 框架的配置
 * @Author: Wjh
 * @Date: 2020/11/9 11:36
 * @Modified By:
 */
@ConfigurationProperties(prefix = "imooc.security")
@Data
public class SecurityProperties {

    /**
     * 项目相关配置
     */
    private BrowserProperties browser = new BrowserProperties();

    /**
     * 验证码的属性
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();
}

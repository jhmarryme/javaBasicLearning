package com.imooc.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * description: 框架的配置入口
 * @Author: Wjh
 * @Date: 2020/11/9 11:36
 * @Modified By:
 */
@ConfigurationProperties(prefix = "imooc.security")
@Data
public class SecurityProperties {

    /**
     * 针对browser的项目相关配置
     */
    private BrowserProperties browser = new BrowserProperties();

    /**
     * 验证码的相关配置
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();

    /**
     * social的相关配置
     */
    private SocialProperties social = new SocialProperties();
}

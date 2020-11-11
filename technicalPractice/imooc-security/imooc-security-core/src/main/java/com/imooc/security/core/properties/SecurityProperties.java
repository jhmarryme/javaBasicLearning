package com.imooc.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/11/9 11:36
 * @Modified By:
 */
@ConfigurationProperties(prefix = "imooc.security")
@Data
public class SecurityProperties {
    private BrowserProperties browser = new BrowserProperties();
}

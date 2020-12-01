package com.imooc.security.core.properties;

import lombok.Data;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/11/9 11:23
 * @Modified By:
 */
@Data
public class BrowserProperties {
    /**  
     * 提供默认的登录页面
     */
    private String loginPage = "/imooc-login.html";

    /**  
     * 默认的登录返回类型为JSON, 可配置为REDIRECT
     */
    private LoginType loginType = LoginType.JSON;
}

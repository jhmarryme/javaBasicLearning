package com.imooc.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * 指定springsocial成功处理器的接口
 * @author Jiahao Wang
 * @date 2021/2/25 15:06
 */
public interface SocialAuthenticationFilterPostProcessor {

    /**
     * 参数为springsocial的过滤器  
     * @param socialAuthenticationFilter
     */
    void process(SocialAuthenticationFilter socialAuthenticationFilter);
}
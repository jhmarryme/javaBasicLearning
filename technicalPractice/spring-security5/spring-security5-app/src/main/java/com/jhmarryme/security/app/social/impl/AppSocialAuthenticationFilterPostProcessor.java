package com.jhmarryme.security.app.social.impl;

import com.jhmarryme.security.core.social.SocialAuthenticationFilterPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * 设置app下springSocial走的成功处理器
 * @author JiaHao Wang
 * @date 2021/2/25 15:07
 */
@Component
public class AppSocialAuthenticationFilterPostProcessor implements SocialAuthenticationFilterPostProcessor {

    /**
     * 认证成功后返回token的成功处理器
     */
    @Autowired
    private AuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

    @Override
    public void process(SocialAuthenticationFilter socialAuthenticationFilter) {
        socialAuthenticationFilter.setAuthenticationSuccessHandler(imoocAuthenticationSuccessHandler);
    }

}

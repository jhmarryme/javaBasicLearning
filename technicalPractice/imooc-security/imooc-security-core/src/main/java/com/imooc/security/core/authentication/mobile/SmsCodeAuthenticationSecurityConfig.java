package com.imooc.security.core.authentication.mobile;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

/**
 * description: 
 * @author: JiaHao Wang
 * @date: 2020/12/8 12:05
 * @modified By:
 */
public class SmsCodeAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain,
        HttpSecurity> {
    @Override
    public void configure(HttpSecurity http) throws Exception {

        AbstractAuthenticationProcessingFilter smsCodeAuthenticationFilter = new SmsCodeAuthenticationFilter();

        smsCodeAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));

    }
}

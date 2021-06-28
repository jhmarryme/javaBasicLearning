package com.jhmarryme.security.app;

import com.jhmarryme.security.app.social.openId.OpenIdAuthenticationSecurityConfig;
import com.jhmarryme.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.jhmarryme.security.core.properties.SecurityConstants;
import com.jhmarryme.security.core.properties.SecurityProperties;
import com.jhmarryme.security.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * 资源服务器 相关配置
 * @author Jiahao Wang
 * @date 2021/2/19 10:43
 */
@Configuration
@EnableResourceServer
public class ImoocResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    protected AuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler imoocAuthenticationFailureHandler;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private SpringSocialConfigurer imoocSocialSecurityConfig;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                // 当未登录时, 跳转的路径
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATED_URL)
                // 登录请求的处理路径, 提交username和password的URL, 默认配置 UsernamePasswordAuthenticationFilter中 login
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                // 认证 成功/失败 的处理逻辑
                .successHandler(imoocAuthenticationSuccessHandler)
                .failureHandler(imoocAuthenticationFailureHandler);

        http
            .apply(validateCodeSecurityConfig)
                .and()
            .apply(smsCodeAuthenticationSecurityConfig)
                .and()
            .apply(openIdAuthenticationSecurityConfig)
                .and()
            .apply(imoocSocialSecurityConfig)
                .and()
            .authorizeRequests()
            // 不需要登录的路径
            .antMatchers(
                    SecurityConstants.DEFAULT_UNAUTHENTICATED_URL,
                    SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                    SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_OPENID,
                    SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                    securityProperties.getBrowser().getLoginPage(),
                    securityProperties.getBrowser().getSignUpUrl(),
//                        securityProperties.getBrowser().getSignOutUrl(),
                    securityProperties.getBrowser().getSession().getSessionInvalidUrl() + ".html",
                    // 该路径由于只有业务系统知道, 还需进一步抽取
                    "/user/register",
                    "/social/signUp"
                ).permitAll()
            // 其他所有请求都需要认证
            .anyRequest()
            .authenticated()
            .and()
            .csrf()
            .disable();
    }
}
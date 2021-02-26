package com.imooc.security.browser;

import com.imooc.security.core.support.SimpleResponse;
import com.imooc.security.core.support.SocialUserInfo;
import com.imooc.security.core.properties.SecurityConstants;
import com.imooc.security.core.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Browser认证配置
 * @author Jiahao Wang
 * @date 2020/11/9 9:02
 */
@RestController
@Slf4j
public class BrowserSecurityController {

    /**
     * spring会把请求缓存到该对象
     */
    RequestCache requestCache = new HttpSessionRequestCache();

    /**
     * session工具类
     */
    RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    /**
     * 系统配置参数类
     */
    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    /**
     * 配置的认证引导页, 当未登录时会访问这里
     * <br/>
     * @author Jiahao Wang
     * @date 2020/12/7 9:13
     * @param request request对象
     * @param response response对象
     * @return com.imooc.security.core.support.SimpleResponse
     */
    @RequestMapping(SecurityConstants.DEFAULT_UNAUTHENTICATED_URL)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) {
        Optional.ofNullable(requestCache.getRequest(request, response))
                .ifPresent(
                        savedRequest -> {
                            log.info("引发跳转的请求时: {}", savedRequest.getRedirectUrl());
                            // 当用户未登录时, 判断访问的路径是否是 .html结尾
                            if (StringUtils.endsWithIgnoreCase(savedRequest.getRedirectUrl(), ".html")) {
                                try {
                                    // 如果是 跳转到配置的登录页中
                                    redirectStrategy.sendRedirect(
                                            request,
                                            response,
                                            securityProperties.getBrowser().getLoginPage()
                                    );
                                } catch (IOException e) {
                                    log.debug("处理请求url失败: {}", e.getMessage());
                                }
                            }
                        });
        return new SimpleResponse("访问的服务需要身份认证，请引导用户到登录页");
    }

    /**
     * 获取社交登录的用户相关信息
     * <br/>
     * @author Jiahao Wang
     * @date 2021/1/26 17:15
     * @param request request
     * @return com.imooc.security.core.support.SocialUserInfo
     */
    @GetMapping("/social/user")
    public SocialUserInfo getSocialUserInfo(HttpServletRequest request) {

        SocialUserInfo socialUserInfo = new SocialUserInfo();

        // SocialAuthenticationFilter中的doAuthentication方法中负责存入session, 从这里取出
        Connection<?> connection =
                providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));

        socialUserInfo.setProviderId(connection.getKey().getProviderId());
        socialUserInfo.setProviderUserId(connection.getKey().getProviderUserId());
        socialUserInfo.setNickname(connection.getDisplayName());
        socialUserInfo.setHeadImg(connection.getImageUrl());

        return socialUserInfo;
    }


}

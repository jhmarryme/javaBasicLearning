package com.imooc.security.browser;

import com.imooc.security.browser.support.SimpleResponse;
import com.imooc.security.core.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/11/9 9:02
 * @Modified By:
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

    /**
     * 配置的认证引导页, 当用户未登录时, 判断访问的路径是否是 .html结尾, 如果是 跳转到配置的登录页
     * <br/>
     * @author Jiahao Wang
     * @date 2020/12/7 9:13
     * @param request
     * @param response
     * @return com.imooc.security.browser.support.SimpleResponse
     * @throws
     */
    @RequestMapping("/authentication/require")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) {
        Optional.ofNullable(requestCache.getRequest(request, response))
                .ifPresent(
                        savedRequest -> {
                            if (StringUtils.endsWithIgnoreCase(savedRequest.getRedirectUrl(), ".html")) {
                                try {
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
}

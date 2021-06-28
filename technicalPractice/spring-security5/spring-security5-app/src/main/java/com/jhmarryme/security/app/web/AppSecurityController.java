package com.jhmarryme.security.app.web;

import com.jhmarryme.security.app.utils.AppSignUpUtils;
import com.jhmarryme.security.core.support.SocialUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * 将社交账户从session转存到redis，并返回给APP一个社交登陆失败的原因+社交账户信息（便于APP前端显示当前社交账户的用户名、头像等信息）
 * @author JiaHao Wang
 * @date 2021/2/26 11:20
 */
@RestController
public class AppSecurityController {

    @Autowired
    private AppSignUpUtils appSignUpUtils;

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @GetMapping("/social/signUp")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
        SocialUserInfo userInfo = new SocialUserInfo();
        // 从session中取出已经认证的社交账户信息（Connection对象）
        // -->本接口的执行和微信、QQ的等服务提供商拿着授权码回调我们的项目在一个session里，因此这里可以从session里取出社交账户信息
        Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
        userInfo.setProviderId(connection.getKey().getProviderId());
        userInfo.setProviderUserId(connection.getKey().getProviderUserId());
        userInfo.setNickname(connection.getDisplayName());
        userInfo.setHeadImg(connection.getImageUrl());

        //从session里将社交账户信息取出并转存到redis
        appSignUpUtils.saveConnectionData(new ServletWebRequest(request), connection.createData());
        return userInfo;
    }
}

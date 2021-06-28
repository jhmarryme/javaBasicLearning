package com.jhmarryme.security.app.social.openId;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

import java.util.Collection;

/**
 * 基于简化模式返回的openId 社交登录token
 *
 * 模仿UsernamePasswordAuthenticationToken --- 该token用来封装登陆信息
 * @author Jiahao Wang
 * @date 2021/2/24 17:34
 */
public class OpenIdAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    /** 即openId */
    private final Object principal;

    /** providerId用来区分是哪个服务提供商 */
    private String providerId;

    public OpenIdAuthenticationToken(String openId, String providerId) {
        super(null);
        this.principal = openId;
        this.providerId = providerId;
        setAuthenticated(false);
    }

    public OpenIdAuthenticationToken(Object principal,
                                     Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    public String getProviderId() {
        return providerId;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException(
                    "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        }

        super.setAuthenticated(false);
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
    }
}
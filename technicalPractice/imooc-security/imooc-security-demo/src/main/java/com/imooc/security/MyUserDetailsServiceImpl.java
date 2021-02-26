package com.imooc.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * 配置用户信息校验逻辑
 * @author JiaHao Wang
 * @date 2020/10/29 12:35
 */
@Component
@Slf4j
public class MyUserDetailsServiceImpl implements UserDetailsService, SocialUserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("表单登录用户名: {}", username);
        return buildUser(username);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        log.info("社交登录用户名: {}", userId);

        return buildUser(userId);
    }

    private SocialUser buildUser(String userId) {
        // 根据用户名查找用户

        // 根据查到的用户信息判断用户状态是否正常

        // 模拟加密后的密码
        String password = passwordEncoder.encode("123456");
        log.info("数据库密码为: {}", password);
        // 使用工具类将字符串转换为 需要的授权对象list
        return new SocialUser(
                userId,
                password,
                true,
                true,
                true,
                true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin, super_admin, ROLE_USER"));
    }
}

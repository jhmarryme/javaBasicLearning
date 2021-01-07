package com.imooc.security.browser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * description: 配置用户信息校验逻辑
 * @Author: Wjh
 * @Date: 2020/10/29 12:35
 * @Modified By:
 */
@Component
@Slf4j
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("用户名: {}", username);

        // 根据用户名查找用户

        // 根据查到的用户信息判断用户状态是否正常

        // 模拟加密后的密码
        String password = passwordEncoder.encode("123456");
        log.info("密码: {}", password);
        // 使用工具类将字符串转换为 需要的授权对象list
        return new User(
                username,
                password,
                true,
                true,
                true,
                true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin, super_admin"));
    }
}

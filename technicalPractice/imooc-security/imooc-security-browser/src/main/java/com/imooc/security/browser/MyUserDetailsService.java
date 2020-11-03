package com.imooc.security.browser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * description: 配置用户信息校验逻辑
 * @Author: Wjh
 * @Date: 2020/10/29 12:35
 * @Modified By:
 */
@Component
@Slf4j
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("username: {}", username);

        // 根据用户名查找用户

        // 根据查到的用户信息判断用户状态是否正常


        // 使用工具类将字符串转换为 需要的授权对象list
        return new User(username,
                "123456",
                true,
                true,
                true,
                true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin, super_admin"));
    }
}

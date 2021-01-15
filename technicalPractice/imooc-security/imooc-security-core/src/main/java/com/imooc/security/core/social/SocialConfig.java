package com.imooc.security.core.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * description: spring social 相关配置
 * @author JiaHao Wang
 * @date 2021/1/11 13:01
 */
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    /**
     * 配置 UsersConnectionRepository
     * <br/>
     * @param connectionFactoryLocator 用于查找当前应该使用的connectionFactory
     * @return org.springframework.social.connect.UsersConnectionRepository
     */
    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        // Encryptors用于将插入数据库的数据做加解密, 这里不做加密
        JdbcUsersConnectionRepository repository =
                new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());

        // 默认的表名为 `UserConnection`, 实际为`imooc_UserConnection`, 需要设置前缀
        repository.setTablePrefix("imooc_");
        return repository;
    }

    /**
     * 创建一个bean对象
     *      该bean用于往当前的过滤器链中添加一个过滤器, 用于拦截特定的请求, 引导用户进行社交登录
     *      在{@link com.imooc.security.browser.BrowserSecurityConfig} 中被引用
     * <br/>
     * @return org.springframework.social.security.SpringSocialConfigurer
     */
    @Bean
    public SpringSocialConfigurer imoocSocialSecurityConfig() {
        return new SpringSocialConfigurer();
    }
}

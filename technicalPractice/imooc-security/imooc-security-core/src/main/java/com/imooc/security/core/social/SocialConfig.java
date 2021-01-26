package com.imooc.security.core.social;

import com.imooc.security.core.properties.SecurityProperties;
import com.imooc.security.core.social.qq.ImoocSocialSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;
import java.util.Optional;

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

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired(required = false)
    private ConnectionSignUp connectionSignUp;

    /**
     * 配置 UsersConnectionRepository
     * <br/>
     * @param connectionFactoryLocator 用于查找当前应该使用的connectionFactory
     * @return org.springframework.social.connect.UsersConnectionRepository
     */
    @Primary
    @Bean
    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        // Encryptors用于将插入数据库的数据做加解密, 这里不做加密
        JdbcUsersConnectionRepository repository =
                new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());

        // 默认的表名为 `UserConnection`, 实际为`imooc_UserConnection`, 需要设置前缀
        repository.setTablePrefix("imooc_");
        // 如果 client 实现了该接口才设置进去
        Optional.ofNullable(connectionSignUp).ifPresent(repository::setConnectionSignUp);
        return repository;
    }

    /**
     * 创建一个bean对象
     *      该bean用于往当前的过滤器链中添加一个过滤器, 用于拦截特定的请求, 引导用户进行社交登录
     *      {@link SpringSocialConfigurer} 的configure方法 new了一个 {@link SocialAuthenticationFilter}
     *      使用postProcess方法处理后, 将其添加到过滤器链中
     *      在{@link com.imooc.security.browser.BrowserSecurityConfig} 中被引用
     * <br/>
     * @return org.springframework.social.security.SpringSocialConfigurer
     */
    @Bean
    public SpringSocialConfigurer imoocSocialSecurityConfig() {
        ImoocSocialSecurityConfig socialSecurityConfig =
                new ImoocSocialSecurityConfig(securityProperties.getSocial().getFilterProcessesUrl());
        socialSecurityConfig.signupUrl(securityProperties.getBrowser().getSignUpUrl());
        return socialSecurityConfig;
    }

    
    /**
     * 创建一个用于 社交登录相关操作的工具类
     *      - doPostSignUp() 用于完成注册
     *      - getConnectionFromSession 用于获取用户信息
     * <br/>
     * @author Jiahao Wang
     * @date 2021/1/26 17:16
     * @param connectionFactoryLocator 由spring创建, 这里只需要注入即可
     * @return org.springframework.social.connect.web.ProviderSignInUtils
     */
    @Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator) {
        return new ProviderSignInUtils(connectionFactoryLocator, getUsersConnectionRepository(connectionFactoryLocator));
    }
}

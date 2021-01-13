package com.imooc.security.core.social.qq.connect;

import com.imooc.security.core.properties.QQProperties;
import com.imooc.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * description: qq相关配置,
 *      在{@link com.imooc.security.browser.BrowserSecurityConfig} 中被引用
 * @author JiaHao Wang
 * @date 2021/1/13 15:15
 */
@Configuration
@ConditionalOnProperty(prefix = "imooc.security.social.qq", name = "appId")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    protected ConnectionFactory<?> createConnectionFactory() {

        QQProperties qqProperties = securityProperties.getSocial().getQq();

        return new QQConnectionFactory(qqProperties.getPrividerId(), qqProperties.getAppId(), qqProperties.getAppSecret());
    }

    @Bean
    public SpringSocialConfigurer imoocSpringSocialConfigurer() {
        return new SpringSocialConfigurer();
    }
}

package com.imooc.security.core.social.qq.config;

import com.imooc.security.core.properties.QQProperties;
import com.imooc.security.core.properties.SecurityProperties;
import com.imooc.security.core.social.qq.connect.QQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

/**
 * description: qq相关配置, 
 *      实现 {@link SocialAutoConfigurerAdapter}中createConnectionFactory方法
 *      当配置文件中存在imooc.security.social.qq.appId的时候, 该配置才会生效
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
        // 提供 ProviderId, appId, AppSecret
        return new QQConnectionFactory(qqProperties.getPrividerId(), qqProperties.getAppId(), qqProperties.getAppSecret());
    }

}

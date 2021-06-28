package com.jhmarryme.security.core.social.qq.config;

import com.jhmarryme.security.core.properties.QQProperties;
import com.jhmarryme.security.core.properties.SecurityProperties;
import com.jhmarryme.security.core.social.qq.connect.QQConnectionFactory;
import com.jhmarryme.security.core.social.utils.SocialAutoConfigurerAdapter;
import com.jhmarryme.security.core.social.views.ImoocConnectView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.web.servlet.View;

/**
 * qq相关配置,
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

    /**
     * 提供绑定/解绑社交账号的视图
     * connect为默认值, {providerId} +Connect: 解绑视图, + Connected: 绑定视图
     * <br/>
     * @return org.springframework.web.servlet.View
     */
    @Bean({"connect/qqConnect", "connect/qqConnected"})
    @ConditionalOnMissingBean(name = "qqConnectedView")
    public View qqConnectedView() {
        return new ImoocConnectView();
    }
}

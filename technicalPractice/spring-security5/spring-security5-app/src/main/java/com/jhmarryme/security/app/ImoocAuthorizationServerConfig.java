package com.jhmarryme.security.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * 认证服务器
 * @author Jiahao Wang
 * @date 2021/2/9 11:13
 */
@Configuration
@EnableAuthorizationServer
public class ImoocAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {


    /**
     * 对正在进行授权的用户进行认证+校验时需要用到
     */
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenStore redisTokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private TokenEnhancer jwtTokenEnhancer;

    /***
     * 入口点相关配置  ---  token的生成，存储方式等在这里配置
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                //指定使用的TokenStore，tokenStore用来存取token，默认使用InMemoryTokenStore
                //这里使用redis存储token
                .tokenStore(redisTokenStore)
                //下面的配置主要用来指定"对正在进行授权的用户进行认证+校验"的类
                //在实现了AuthorizationServerConfigurerAdapter适配器类后，必须指定下面两项
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
        //将JwtAccessTokenConverter设置到token的生成类中
        if (jwtAccessTokenConverter != null && jwtTokenEnhancer != null) {
            //配置增强器链
            // 并利用增强器链将生成jwt的TokenEnhancer（jwtAccessTokenConverter）
            // 和我们扩展的TokenEnhancer设置到token的生成类中
            TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
            List<TokenEnhancer> enhancers = new ArrayList<>();
            enhancers.add(jwtTokenEnhancer);
            enhancers.add(jwtAccessTokenConverter);
            enhancerChain.setTokenEnhancers(enhancers);
            endpoints.tokenEnhancer(enhancerChain);
        }
    }

    /***
     * 第三方客户端相关的配置在这里进行配置 ,之前我们在yml配置文件里对客户端进行过简单的配置
     * 在这里进行配置会覆盖yml中的配置
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //注意：可配置的内容不止下面几个
        clients.inMemory()
                    //设置client-id和client-secret，注意client-secret必须要进行加密处理
                .withClient("imooc")
                    .secret("imoocsecret")
                    //设置accessToken的过期时间
                    .accessTokenValiditySeconds(600)
                    //客户端可以进行认证的方式
                    .authorizedGrantTypes("refresh_token", "authorization_code", "password")
                    //客户端能请求的授权类型
                    .scopes("read", "write")
                    .and()
                //指定另一个客户端
                .withClient("wjh")
                    .secret("123456")
                    .accessTokenValiditySeconds(1200)
                    .authorizedGrantTypes("refresh_token", "authorization_code", "password")
                    .accessTokenValiditySeconds(7200)
                    .refreshTokenValiditySeconds(2592000)
                    .scopes("all");
    }
}
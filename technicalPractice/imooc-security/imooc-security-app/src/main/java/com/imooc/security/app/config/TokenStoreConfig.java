package com.imooc.security.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * TokenStore的实现类有5个，这里将RedisTokenStore注入spring容器
 * @author Jiahao Wang
 * @date 2021/2/26 16:51
 */
@Configuration
public class TokenStoreConfig {

    /***
     * RedisTokenStore需要一个连接工厂，这里可以直接注入进来
     */
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    /***
     * 将RedisTokenStore注入到spring容器
     * @return tokenStore
     */
    @Bean
    public TokenStore redisTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }
}

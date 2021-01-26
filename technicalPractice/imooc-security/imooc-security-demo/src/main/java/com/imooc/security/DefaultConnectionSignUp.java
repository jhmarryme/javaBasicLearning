package com.imooc.security;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * description: 自动注册账户的业务逻辑
 * @author JiaHao Wang
 * @date 2021/1/26 16:20
 */
@Component
public class DefaultConnectionSignUp implements ConnectionSignUp {
    
    /**
     * 根据社交用户信息默认创建用户并返回用户唯一标识
     * <br/>
     * @author Jiahao Wang
     * @date 2021/1/26 17:19
     * @param connection connection
     * @return java.lang.String
     */
    @Override
    public String execute(Connection<?> connection) {
        // 在这里完成业务系统中的用户注册

        // 将新注册的userId返回, 上层会将userId与social账户绑定, 这里简单返回即可
        return connection.getDisplayName();
    }
}

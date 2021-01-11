package com.imooc.security.core.social.qq.api;

/**
 * description: 
 * @author JiaHao Wang
 * @date 2021/1/8 12:32
 */
public interface QQ {

    /**
     * 获取 qq用户信息
     * <br/>
     * @return com.imooc.security.core.social.qq.api.QQUserInfo
     */
    QQUserInfo getQQUserInfo();
}

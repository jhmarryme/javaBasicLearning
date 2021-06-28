package com.jhmarryme.security.core.social.qq.connect;

import com.jhmarryme.security.core.social.qq.api.QQ;
import com.jhmarryme.security.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * 用于将 qq提供的数据 适配为 业务需要的数据
 * @author JiaHao Wang
 * @date 2021/1/11 12:51
 */
public class QQApiAdapter implements ApiAdapter<QQ> {

    /**
     * 测试服务是否可用
     * <br/>
     * @param qq
     * @return boolean
     */
    @Override
    public boolean test(QQ qq) {
        return true;
    }

    @Override
    public void setConnectionValues(QQ qq, ConnectionValues connectionValues) {

        QQUserInfo userInfo = qq.getQQUserInfo();

        // openID
        connectionValues.setProviderUserId(userInfo.getOpenId());
        // 用户名
        connectionValues.setDisplayName(userInfo.getNickname());
        // 如 微博的个人主页
        connectionValues.setProfileUrl(null);
        // 头像
        connectionValues.setImageUrl(userInfo.getFigureurl_qq_1());

    }

    @Override
    public UserProfile fetchUserProfile(QQ qq) {
        return null;
    }

    @Override
    public void updateStatus(QQ qq, String s) {
        // 不做处理
    }
}

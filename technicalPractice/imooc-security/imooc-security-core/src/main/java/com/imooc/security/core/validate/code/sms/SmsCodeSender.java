package com.imooc.security.core.validate.code.sms;

/**
 * description: 
 * @author: JiaHao Wang
 * @date: 2020/12/3 19:01
 * @modified By:
 */
public interface SmsCodeSender {

    /**
     * 发送短信验证码
     * <br/>
     * @param mobile
     * @param code
     * @return void
     */
    void send(String mobile, String code);
}
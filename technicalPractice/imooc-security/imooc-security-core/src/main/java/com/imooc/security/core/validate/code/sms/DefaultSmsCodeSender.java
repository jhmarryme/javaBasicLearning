package com.imooc.security.core.validate.code.sms;

/**
 * description: 
 * @author: JiaHao Wang
 * @date: 2020/12/3 19:11
 * @modified By:
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        System.out.printf("已向手机号:%s发送验证码:%s", mobile, code);
    }
}

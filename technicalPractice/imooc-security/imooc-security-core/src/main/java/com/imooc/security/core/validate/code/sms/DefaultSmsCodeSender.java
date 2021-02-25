package com.imooc.security.core.validate.code.sms;

import lombok.extern.slf4j.Slf4j;

/**
 * description: 
 * @author: JiaHao Wang
 * @date: 2020/12/3 19:11
 * @modified By:
 */
@Slf4j
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        log.info("已向手机号:{}发送验证码:{}", mobile, code);
    }
}

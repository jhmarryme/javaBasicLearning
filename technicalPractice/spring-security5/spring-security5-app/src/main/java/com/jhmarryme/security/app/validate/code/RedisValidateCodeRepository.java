package com.jhmarryme.security.app.validate.code;

import com.jhmarryme.security.core.validate.code.ValidateCodeRepository;
import com.jhmarryme.security.core.validate.code.base.ValidateCode;
import com.jhmarryme.security.core.validate.code.base.ValidateCodeException;
import com.jhmarryme.security.core.validate.code.base.ValidateCodeTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 基于redis的验证码存取器
 * @author Jiahao Wang
 * @date 2021/2/23 12:28
 */
@Slf4j
@Component
public class RedisValidateCodeRepository implements ValidateCodeRepository {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * 设备id
     */
    private static final String DEVICE_ID = "deviceId";

    @Override
    public void save(ServletWebRequest request, ValidateCode code, ValidateCodeTypeEnum validateCodeTypeEnum) {
        redisTemplate.opsForValue().set(buildKey(request, validateCodeTypeEnum), code, 30, TimeUnit.MINUTES);
    }

    @Override
    public Optional<ValidateCode> get(ServletWebRequest request, ValidateCodeTypeEnum validateCodeTypeEnum) {
        Object value = redisTemplate.opsForValue().get(buildKey(request, validateCodeTypeEnum));
        if (value == null) {
            log.warn("不存在对应的验证码");
            return Optional.empty();
        }
        return Optional.of((ValidateCode) value);
    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeTypeEnum validateCodeTypeEnum) {
        redisTemplate.delete(buildKey(request, validateCodeTypeEnum));
    }

    /**
     * 根据请求的设备生成验证码的key，如果同一个设备多次请求 则先前的验证码则被覆盖无效
     *
     * @param request
     * @param validateCodeTypeEnum
     * @return String redis存储的key
     */
    private String buildKey(ServletWebRequest request, ValidateCodeTypeEnum validateCodeTypeEnum) {
        String deviceId = request.getHeader(DEVICE_ID);
        if (StringUtils.isBlank(deviceId)) {
            throw new ValidateCodeException("请在请求头中携带deviceId参数");
        }
        String codeKey = validateCodeTypeEnum.getParamNameOnValidate().concat(":").concat(deviceId);
        log.info("本次请求生成的codeKey:{}", codeKey);
        return codeKey;
    }

}
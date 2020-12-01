package com.imooc.security.core.validate.code;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * description: 图片验证码
 * @Author: Wjh
 * @Date: 2020/11/30 12:29
 * @Modified By:
 */
@Data
@AllArgsConstructor
public class ImageCode {

    /**
     * 图片验证码
     */
    private BufferedImage image;
    
    /**
     * 验证码
     */
    private String code;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    public ImageCode(BufferedImage image, String code, int expireIn) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    /**
     * 验证码是否过期
     * <br/>
     * @author Jiahao Wang
     * @date 2020/11/30 20:05
     * @param  
     * @return boolean
     */
    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}

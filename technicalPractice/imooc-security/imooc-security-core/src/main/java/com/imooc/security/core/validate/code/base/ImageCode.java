package com.imooc.security.core.validate.code.base;

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
public class ImageCode extends ValidateCode {

    /**
     * 图片验证码
     */
    private BufferedImage image;

    public ImageCode(BufferedImage image, String code, int expireIn) {
        super(code, expireIn);
        this.image = image;
    }

}

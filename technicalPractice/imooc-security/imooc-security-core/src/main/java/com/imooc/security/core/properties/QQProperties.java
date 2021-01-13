package com.imooc.security.core.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * description: 
 * @author JiaHao Wang
 * @date 2021/1/12 9:01
 */
@Data
public class QQProperties extends SocialProperties {

    private String prividerId = "qq";
}

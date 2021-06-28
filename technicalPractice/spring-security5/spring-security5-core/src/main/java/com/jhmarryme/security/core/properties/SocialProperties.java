package com.jhmarryme.security.core.properties;

import lombok.Data;

/**
 *
 * @author JiaHao Wang
 * @date 2021/1/12 9:01
 */
@Data
public class SocialProperties {

    private String filterProcessesUrl = "/auth";

    private QQProperties qq = new QQProperties();
}

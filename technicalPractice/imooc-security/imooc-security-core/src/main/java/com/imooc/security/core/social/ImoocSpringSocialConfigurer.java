package com.imooc.security.core.social;

import lombok.Data;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * description: 通过继承SpringSocialConfigurer, 重写postProcess方法修改配置
 * @author JiaHao Wang
 * @date 2021/1/19 9:43
 */
@Data
public class ImoocSpringSocialConfigurer extends SpringSocialConfigurer {

    /**
     * 请求/回调地址前缀
     */
    private final String filterProcessesUrl;

    private SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor;

    public ImoocSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    /**
     * 配置过滤器, 设置filterProcessesUrl
     * <br/>
     * @param object 过滤器
     * @return T
     */
    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        if (socialAuthenticationFilterPostProcessor != null) {
            socialAuthenticationFilterPostProcessor.process(filter);
        }
        return (T) filter;
    }
}

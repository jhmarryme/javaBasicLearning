package com.jhmarryme.security.app;

import com.jhmarryme.security.core.social.ImoocSpringSocialConfigurer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * description: 
 * @author JiaHao Wang
 * @date 2021/2/26 11:05
 */
@Component
public class SpringSocialConfigurerPostProcessor implements BeanPostProcessor {

    /**
     * spring启动时所有的bean初始化之前都会调用该方法 --- 可以在bean初始化之前对bean做一些操作
     * <br/>
     * @param bean
     * @param beanName
     * @return java.lang.Object
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (StringUtils.equals(beanName, "imoocSpringSocialConfigurer")) {
            ImoocSpringSocialConfigurer configurer = (ImoocSpringSocialConfigurer) bean;
            configurer.signupUrl("/social/signUp");
        }
        return bean;
    }
}

package cn.jhmarryme.practiceproject.config;

import cn.jhmarryme.practiceproject.filter.MyFilter;
import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author jhmarryme.cn
 * @date 2019/10/24 10:59
 */
@Configuration
public class FilterConfig {

   /* @Bean
    public RemoteIpFilter remoteIpFilter(){
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());//添加过滤器
        registration.addUrlPatterns("/*");//设置过滤路径，/*所有路径
        registration.addInitParameter("name", "alue");//添加默认参数
        registration.setName("MyFilter");//设置优先级
        registration.setOrder(1);//设置优先级
        return registration;
    }*/
}

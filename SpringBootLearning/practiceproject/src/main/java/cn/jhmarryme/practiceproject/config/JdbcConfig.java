package cn.jhmarryme.practiceproject.config;

//import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author jhmarryme.cn
 * @date 2019/10/23 10:32
 */
@Configuration
//@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {

    /*@Value("${jdbc.url}")
    String url;
    @Value("${jdbc.driverClassName}")
    String driverClassName;
    @Value("${jdbc.username}")
    String username;
    @Value("${jdbc.password}")
    String password;

    @Bean
    public DataSource dataSource(){
        final DruidDataSource source = new DruidDataSource();
        source.setUrl(url);
        source.setDriverClassName(driverClassName);
        source.setUsername(username);
        source.setPassword(password);

        return source;
    }*/

}

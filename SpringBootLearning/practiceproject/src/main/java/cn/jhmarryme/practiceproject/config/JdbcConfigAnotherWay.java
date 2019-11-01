package cn.jhmarryme.practiceproject.config;

//import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author jhmarryme.cn
 * @date 2019/10/23 10:43
 */
@Configuration
@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfigAnotherWay {

    /*@Bean
    public DataSource dataSource(JdbcProperties properties){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getUrl());
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        System.out.println("---------------");
        System.out.println("---------------");
        System.out.println("---------------");
        System.out.println("---------------");
        return dataSource;
    }*/
}

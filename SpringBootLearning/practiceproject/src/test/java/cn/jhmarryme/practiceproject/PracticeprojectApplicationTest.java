package cn.jhmarryme.practiceproject;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jhmarryme.cn
 * @date 2019/10/19 23:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class PracticeprojectApplicationTest {

//    @Autowired
//    DataSourceProperties properties;

//    @Autowired
//    ApplicationContext applicationContext;

    @Autowired
    DataSource dataSource;
    @Test
    public void testDataSource(){

        System.out.println("----------------");
        System.out.println("----------------");
        System.out.println("----------------");
        System.out.println("----------------");
        System.out.println(dataSource.getClass());
    }
}
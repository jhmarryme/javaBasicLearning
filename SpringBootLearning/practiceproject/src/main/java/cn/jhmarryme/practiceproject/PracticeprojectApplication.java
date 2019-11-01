package cn.jhmarryme.practiceproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("cn.jhmarryme")
@ServletComponentScan
public class PracticeprojectApplication {
    public static void main(String[] args) {
        SpringApplication.run(PracticeprojectApplication.class, args);
    }

}

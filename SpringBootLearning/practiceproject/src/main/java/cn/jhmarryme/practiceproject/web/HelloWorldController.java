package cn.jhmarryme.practiceproject.web;

import cn.jhmarryme.practiceproject.pojo.UserInfo;
import cn.jhmarryme.practiceproject.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;


/**
 * @author jhmarryme.cn
 * @date 2019/10/19 21:34
 */
@RestController
public class HelloWorldController {


    @Autowired
    private HelloWorldService service;

    @RequestMapping("/hello")
    public String index(){
        return "Hello World";
    }

    @RequestMapping("/userInfo")
    public List<UserInfo> queryAllUserInfo(){
        return service.queryAllUserInfo();
    }
}

package cn.jhmarryme.practiceproject.service;

import cn.jhmarryme.practiceproject.mapper.UserMapper;
import cn.jhmarryme.practiceproject.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author jhmarryme.cn
 * @date 2019/10/23 10:13
 */
@Service
public class HelloWorldService {

    @Autowired
    private UserMapper userMapper;

    public List<UserInfo> queryAllUserInfo(){
        final List<UserInfo> userInfos = userMapper.selectAll();
        return userInfos;
    }


}

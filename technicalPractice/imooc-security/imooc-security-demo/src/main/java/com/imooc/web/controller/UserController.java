package com.imooc.web.controller;

import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @Author: Wjh
 * @Date: 2020/9/8 12:20
 * @Modified By:
 */
@RestController
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> queryUser(UserQueryCondition condition, @PageableDefault(page = 1, size = 15, sort = "username", direction = Sort.Direction.DESC) Pageable pageable) {

        // 使用反射工具类打印condition
        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));

        System.out.println(ReflectionToStringBuilder.toString(pageable, ToStringStyle.MULTI_LINE_STYLE));

        ArrayList<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());

        return users;
    }

    @RequestMapping(value = "/getInfo/{id:\\d+}", method = RequestMethod.GET)
    public User getInfo(@PathVariable(name = "id") String userId) {
        User user = new User();
        user.setUsername("wjh");
        user.setPassword("123");
        return user;
    }
}

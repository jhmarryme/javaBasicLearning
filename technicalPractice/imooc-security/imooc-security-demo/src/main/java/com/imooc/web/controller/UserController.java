package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import com.imooc.exception.UserNotExistException;
import io.swagger.annotations.*;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
@RequestMapping("/user")
@Api("User demo")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    @ApiOperation(value = "根据条件查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, type = "String"),
            @ApiImplicitParam(name = "age", value = "起始年龄", required = true, type = "int"),
            @ApiImplicitParam(name = "ageTo", value = "结束年龄", required = true, type = "int")
    })
    public List<User> query(UserQueryCondition condition, @PageableDefault(page = 1, size = 15, sort = "username",
            direction = Sort.Direction.DESC) Pageable pageable) {

        // 使用反射工具类打印condition
//        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));

//        System.out.println(ReflectionToStringBuilder.toString(pageable, ToStringStyle.MULTI_LINE_STYLE));

        ArrayList<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());

        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    @ApiOperation(value = "获取指定用户详细信息")
    public User getInfo(@ApiParam("用户id") @PathVariable(name = "id") String userId) {

        LOGGER.info("/user/{id} userId: {}", userId);
        User user = new User();
        user.setUsername("wjh");
        user.setPassword("123");
        return user;
    }

    @PostMapping
    @JsonView(User.UserSimpleView.class)
    public User create(@Valid @RequestBody User user, BindingResult errors) {

        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
        }

        System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));

        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {

        LOGGER.info("update: {}", user);

        if (errors.hasErrors()) {
            errors.getFieldErrors().forEach(fieldError -> System.out.println(fieldError.getField() + " : " + fieldError.getDefaultMessage()));
        }

        System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));

        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {

        throw new UserNotExistException(id);
//        System.out.println(id);
    }

}

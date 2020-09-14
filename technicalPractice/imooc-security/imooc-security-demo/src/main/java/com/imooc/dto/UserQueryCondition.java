package com.imooc.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * description:
 *
 * @Author: Wjh
 * @Date: 2020/9/8 12:32
 * @Modified By:
 */
@Data
public class UserQueryCondition {

    private String username;

//    @ApiModelProperty("用户年龄起始值")
    private int ageTo;

//    @ApiModelProperty("用户年龄结束值")
    private int age;

}

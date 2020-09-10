package com.imooc.exception;

import lombok.Data;

/**
 * description: 异常信息
 *
 * @Author: Wjh
 * @Date: 2020/9/10 17:51
 * @Modified By:
 */
@Data
public class UserNotExistException extends RuntimeException {

    private static final long serialVersionUID = -6112780192479692859L;

    private String id;

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }

}

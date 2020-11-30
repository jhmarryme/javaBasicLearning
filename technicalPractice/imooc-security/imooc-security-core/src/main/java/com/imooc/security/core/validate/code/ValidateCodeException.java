package com.imooc.security.core.validate.code;


import org.springframework.security.core.AuthenticationException;

/**
 * description: 
 * @author: JiaHao Wang
 * @date: 2020/11/30 17:56
 * @modified By:
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -302765991473898604L;

    public ValidateCodeException(String explanation) {
        super(explanation);
    }
}

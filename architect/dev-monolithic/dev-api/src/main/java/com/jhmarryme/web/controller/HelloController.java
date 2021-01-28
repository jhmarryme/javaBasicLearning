package com.jhmarryme.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: 
 * @author JiaHao Wang
 * @date 2021/1/26 22:58
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Object hello() {
        return "hello";
    }
}

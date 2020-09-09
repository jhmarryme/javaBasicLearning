package com.imooc.web.service;

import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @Author: Wjh
 * @Date: 2020/9/9 18:16
 * @Modified By:
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void greeting(String name) {

        System.out.println("greeting " + name);
    }
}

package com.imooc.web.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/9/10 19:33
 * @Modified By:
 */
@RestController
public class AsyncController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncController.class);

    @RequestMapping("/order")
    public Callable<String> order() {
        LOGGER.info("主线程开始");

        Callable<String> result = new Callable<String>() {
            @Override
            public String call() throws Exception {
                LOGGER.info("副线程开始");
                Thread.sleep(1000);
                LOGGER.info("副线程开始");
                return "success";
            }
        };

        LOGGER.info("主线程返回");
        return result;
    }
}

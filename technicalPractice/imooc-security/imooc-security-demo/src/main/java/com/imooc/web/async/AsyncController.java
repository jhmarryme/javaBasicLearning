package com.imooc.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

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

    @Autowired
    private DeferredResultHolder resultHolder;

    @Autowired MockQueue mockQueue;

    @RequestMapping("/order")
    public Callable<String> order() {
        LOGGER.info("主线程开始");

        // 将业务交由副线程处理,
        Callable<String> result = () -> {
            LOGGER.info("副线程开始");
            Thread.sleep(1000);
            LOGGER.info("副线程开始");
            return "success";
        };

        LOGGER.info("主线程返回");
        return result;
    }
    /** 模拟deferredResult异步处理rest服务
     * 1. 发送下单请求消息
     * 2. 监听器线程1接收到下单请求消息
     * 3. 线程1 处理消息并返回数据, 发送下单完成消息
     * 4. 监听器线程2 接收到下单完成消息, 将数据放到DeferredResult中, DeferredResult会自动将其响应
     *
     * @Author: Wjh
     * @Since: 2020/9/10 23:19
     **/
    @RequestMapping("/order/deferred")
    public DeferredResult<String> orderDeferred() {
        LOGGER.info("主线程开始");

        // 模拟 发送消息
        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);

        // 创建 用于存放异步处理返回结果
        DeferredResult<String> result = new DeferredResult<>();

        // 将创建的对象交由 DeferredResultHolder管理 等待处理结果
        resultHolder.getMap().put(orderNumber, result);

        LOGGER.info("主线程返回");
        // 当处理完成后, DeferredResult会将处理后的结果返回
        return result;
    }


}

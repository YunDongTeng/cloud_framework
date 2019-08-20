package com.cloud.framework.order.web;

import com.cloud.framework.order.feign.OrderFeignClient;
import com.cloud.framework.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    private static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderFeignClient orderFeignClient;

    @Autowired
    private OrderService orderService;

    @GetMapping("/userInfo")
    public String list(){
        logger.info("订单服务获取userInfo...");
        return orderService.userInfo();
    }

    @GetMapping("/getUserByFeign")
    public String getByFeign(){
        logger.info("订单服务调用Feign接口....");
        return orderFeignClient.user(200019321L);
    }

    @GetMapping("/info")
    public String info(){
        return "order info";
    }

}

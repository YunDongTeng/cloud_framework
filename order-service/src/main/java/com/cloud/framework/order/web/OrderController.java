package com.cloud.framework.order.web;

import com.cloud.framework.order.feign.OrderFeignClient;
import com.cloud.framework.order.service.OrderService;
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


    @Autowired
    private OrderFeignClient orderFeignClient;

    @Autowired
    private OrderService orderService;

    @GetMapping("/userInfo")
    public String list(){
        return orderService.userInfo();
    }

    @GetMapping("/getUserByFeign")
    public String getByFeign(){
        return orderFeignClient.user(200019321L);
    }

    @GetMapping("/info")
    public String info(){
        return "order info";
    }

}

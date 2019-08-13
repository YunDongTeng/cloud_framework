package com.cloud.framework.order.web;

import com.cloud.framework.order.feign.OrderFeignClient;
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
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderFeignClient orderFeignClient;

    @GetMapping("/list")
    public String list(){
       ServiceInstance serviceInstance = loadBalancerClient.choose("user-service");

       String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/900302221";

       System.out.println("URL："+url);
       return restTemplate.getForObject(url,String.class);
    }

    @GetMapping("/getUserByFeign")
    public String getByFeign(){
        return orderFeignClient.user(200019321L);
    }


}

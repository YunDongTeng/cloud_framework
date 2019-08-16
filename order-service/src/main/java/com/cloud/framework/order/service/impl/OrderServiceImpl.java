package com.cloud.framework.order.service.impl;

import com.cloud.framework.order.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "userInfoFallBack")
    @Override
    public String userInfo() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("user-service");

        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/900302221";

        System.out.println("URL："+url);
        return restTemplate.getForObject(url,String.class);
    }

    public String userInfoFallBack(){
        return "订单服务获取用户信息失败";
    }
}

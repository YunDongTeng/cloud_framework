package com.cloud.framework.order.shop.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/shop")
public class ShopController {


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/userList")
    public String userList(){
        return restTemplate.getForObject("http://user-service/user/30004922",String.class);
    }

}

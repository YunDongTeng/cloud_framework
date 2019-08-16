package com.cloud.framework.user.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${test.remote.url}")
    private String url;

    @GetMapping("/url")
    public String url(){
        return url;
    }


    @GetMapping("/{id}")
    public String get(@PathVariable Long id){
        return "用户信息Id:"+id;
    }
}

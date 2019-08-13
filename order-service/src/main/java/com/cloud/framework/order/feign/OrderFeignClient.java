package com.cloud.framework.order.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service")
public interface OrderFeignClient {

    @GetMapping("/user/{userId}")
    String user(@PathVariable(value = "userId") Long userId);

}

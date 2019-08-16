package com.cloud.framework.order.feign;

import com.cloud.framework.order.feign.fallback.OrderFeignFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service",fallback = OrderFeignFallBack.class )
public interface OrderFeignClient {


    @GetMapping("/user/{userId}")
    String user(@PathVariable(value = "userId") Long userId);

}

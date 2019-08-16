package com.cloud.framework.order.feign.fallback;

import com.cloud.framework.order.feign.OrderFeignClient;
import org.springframework.stereotype.Component;


/**
 * 注意：Feign默认禁用Hystrix，需要在配置文件中开启 feign.hystrix.enable=true
 */
@Component
public class OrderFeignFallBack implements OrderFeignClient {

    @Override
    public String user(Long userId) {
        return "订单服务通过feign获取用户失败，用户id:"+userId;
    }
}

package com.cloud.framework.gateway.config;

import com.cloud.framework.gateway.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }

}

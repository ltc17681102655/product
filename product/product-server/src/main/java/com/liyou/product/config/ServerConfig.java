package com.liyou.market.config;

import org.springframework.boot.actuate.endpoint.mvc.EndpointHandlerMappingCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 * @description
 * @copyright: Copyright (c)2017
 * @author: vincent
 * @version: 1.0
 * @date: 2018/4/2
 * </pre>
 */
@Configuration
public class ServerConfig {
    
    @Bean
    public EndpointHandlerMappingCustomizer endpointHandlerMappingCustomizer() {
        return new com.liyou.framework.web.actuator.EndpointWhileListHandlerMapping();
    }
}

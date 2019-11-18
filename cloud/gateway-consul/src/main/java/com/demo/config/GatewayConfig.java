package com.demo.config;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;

/**
 * @author huangjian
 * @version 1.0
 * @date: 2019年09月24日 16:14
 */
public class GatewayConfig {

    /*@Bean
    public RouteDefinitionLocator discoveryClientRouteDefinitionLocator(DiscoveryClient discoveryClient) {
        return new DiscoveryClientRouteDefinitionLocator(discoveryClient);
    }*/
}

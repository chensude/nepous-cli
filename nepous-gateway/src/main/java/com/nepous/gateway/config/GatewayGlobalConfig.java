package com.nepous.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局过滤器样例
 */
@Configuration
@Slf4j
public class GatewayGlobalConfig {


//    @Bean
//    @Order(0)
//    public GlobalFilter filter1() {
//        return (exchange, chain) -> {
//            log.info("进入全局过期器");
//            return chain.filter(exchange);
//        };
//    }
    @Bean
    @Order(-1000)
    public GlobalFilter filter1() {
        return new T();
    }
    class T implements GlobalFilter, Ordered {
        //private static final Logger log = LoggerFactory.getLogger(GatewayApplication.class);

        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            log.info("进入全局过滤器");
            return chain.filter(exchange);
        }

        @Override
        public int getOrder() {
            return -1000;
        }
    }

}

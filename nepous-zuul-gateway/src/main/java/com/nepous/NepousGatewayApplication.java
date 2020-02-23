package com.nepous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class NepousGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(NepousGatewayApplication.class,args);
    }
}

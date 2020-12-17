package com.nepous.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class LogConfigration {

    
    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }
}

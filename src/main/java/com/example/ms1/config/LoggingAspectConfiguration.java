package com.example.ms1.config;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import com.example.ms1.aop.logging.LoggingAspect;

@Configuration
@EnableAspectJAutoProxy
public class LoggingAspectConfiguration {

    @Bean
    @Profile(ApplicationConstants.SPRING_PROFILE_DEVELOPMENT)
    public LoggingAspect loggingAspect(Environment env) {
        return new LoggingAspect(env);
    }
}

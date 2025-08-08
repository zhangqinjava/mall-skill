package com.zq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
@Configuration
public class MyThreadPoolConfig {
    @Bean
    public ThreadPoolExecutor threadPoolExecutor()
    {    //根据自己度武器的配置以及业务来判断，
        return new ThreadPoolExecutor(10
                ,20
                ,10
                , TimeUnit.SECONDS
                ,new LinkedBlockingQueue(100)
                , Executors.defaultThreadFactory()
                ,new ThreadPoolExecutor.AbortPolicy()
        );
    }
}

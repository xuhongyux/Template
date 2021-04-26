package com.xiayu.springboot_demo.configuration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@EnableAsync
@Configuration
@Slf4j
public class ThreadPoolConfiguration implements AsyncConfigurer{
    static int CORE_POOL_SIZE = 4;

    static int MAX_POOL_SIZE = 5;
    
    @Override
    public Executor getAsyncExecutor() {
    	if (log.isInfoEnabled()) {
    		 log.info("Creating Async Task Executor");
    	}
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(CORE_POOL_SIZE);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setQueueCapacity(1000);
        executor.setKeepAliveSeconds(300);
        // 指定用于新创建的线程名称的前缀
        executor.setThreadNamePrefix("Thread-Pools-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy()); 
        executor.initialize();

        if (log.isInfoEnabled()) {
        	log.info("Async Task Executor has initiated");
        }  
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) ->
        log.error("Unexpected error occurred invoking async method: " + method +
                ", args: " + Arrays.toString(params), ex);
    }
}


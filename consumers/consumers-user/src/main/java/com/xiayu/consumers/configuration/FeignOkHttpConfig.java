//package com.xiayu.consumers.configuration;
//
//import feign.Feign;
//import okhttp3.ConnectionPool;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.AutoConfigureBefore;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.cloud.openfeign.FeignAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @author xuhongyu
// * @describe
// * @create 2021-01-07-14:47
// */
//@Configuration
//@ConditionalOnClass(Feign.class)
//@AutoConfigureBefore(FeignAutoConfiguration.class)
//public class FeignOkHttpConfig {
//
//
//    @Bean
//    public okhttp3.OkHttpClient okHttpClient(){
//        return new okhttp3.OkHttpClient.Builder()
//                .readTimeout(60, TimeUnit.SECONDS)
//                .connectTimeout(60, TimeUnit.SECONDS)
//                .writeTimeout(120, TimeUnit.SECONDS)
//                .connectionPool(new ConnectionPool())
//                // .addInterceptor();
//                .build();
//    }
//}

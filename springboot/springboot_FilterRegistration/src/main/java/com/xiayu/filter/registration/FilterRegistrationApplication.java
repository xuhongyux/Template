package com.xiayu.filter.registration;

import com.xiayu.filter.registration.configuration.UserFilter;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuhongyu
 * @describe  FilterRegistration 方式的授权方式
 * @create 2021-01-22-14:28
 */
@SpringBootApplication
public class FilterRegistrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(FilterRegistrationApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean RegistTest(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        UserFilter sessionFilter = new UserFilter();
        registrationBean.setFilter(sessionFilter);
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/*");
        Map<String,String> params = new HashMap<String,String>();
        //需要将servlet的url写在这里
        params.put("excludedPages", "/v2,/swagger-resources,/webjars/springfox-swagger-ui,/swagger-ui.html");
        registrationBean.setInitParameters(params);
        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.setOrder(5);
        return registrationBean;
    }


}

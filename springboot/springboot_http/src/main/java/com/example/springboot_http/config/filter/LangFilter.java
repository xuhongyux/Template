/*
package com.example.springboot_http.filter;

import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


*/
/**
 * @author xuhongyu
 * @create 2021-08-05 14:09
 *//*

@Configuration
public class LangFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        ParameterRequestWrapper changeRequestWrapper = new ParameterRequestWrapper((HttpServletRequest) servletRequest);

        //使用复写后的wrapper
        filterChain.doFilter(changeRequestWrapper, servletResponse);
    }
}*/

package com.xiayu.filter.registration.configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.util.buf.StringUtils;
import org.junit.internal.runners.model.EachTestNotifier;
import org.springframework.beans.BeanUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;


/**
 * @author xuhongyu
 * @describe
 * @create 2021-01-22-14:29
 */
public class UserFilter implements Filter {

    protected static final Log logger = LogFactory.getLog(UserFilter.class);

    private String excludedPages;
    private String[] excludedPageArray;


    @Override
    public void init(FilterConfig config) throws ServletException {
        excludedPages = config.getInitParameter("excludedPages");
        if (excludedPages != null && excludedPages != "") {
            excludedPageArray = excludedPages.split(",");
        }
        return;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        System.out.println("自定义过滤器filter触发,拦截url:"+request.getRequestURI());
        // 判断是否在过滤url之外
        boolean isExcludedPage = false;
        for (String page : excludedPageArray) {
            if (((HttpServletRequest) request).getServletPath().indexOf(page) > -1) {
                isExcludedPage = true;
                break;
            }
        }
        if(isExcludedPage){
            filterChain.doFilter(request, servletResponse);
        }
        try {
            if(request.getParameter("Authorization").equals("xiayu")){
                filterChain.doFilter(request, servletResponse);
            }


        } catch (Exception e) {

        }




    }

    @Override
    public void destroy() {

    }
}

package com.xiayu.filter.registration.configuration;

import com.xiayu.filter.registration.utils.JsonUtils;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Map;


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
            //获取请求行的参数
            String parameter = request.getParameter("authorization");

            //获取请求头的参数
            String testHeaders = request.getHeader("TestHeaders");
            
            //获取请求体中的参数body
            BufferedReader br;
            try {
                br = request.getReader();
                String str, wholeStr = "";
                while((str = br.readLine()) != null){
                    wholeStr += str;
                }
                Map<String, Object> stringObjectMap = JsonUtils.json2map(wholeStr);
                System.out.println(stringObjectMap.toString());
            } catch (IOException e1) {
                logger.error(""+e1);
            }


            if(request.getParameter("authorization").equals("xiayu")){
                filterChain.doFilter(request, servletResponse);
            }


        } catch (Exception e) {

        }




    }

    @Override
    public void destroy() {

    }
}

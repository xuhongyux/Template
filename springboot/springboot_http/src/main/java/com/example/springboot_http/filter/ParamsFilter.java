package com.example.springboot_http.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 类描述：参数过滤器
 */
@Configuration
@WebFilter(urlPatterns = "/*", filterName = "paramsFilter")
public class ParamsFilter extends OncePerRequestFilter {
    private byte[] body = null;

    private String bodyString;
    /**
     * Same contract as for {@code doFilter}, but guaranteed to be
     * just invoked once per request within a single request thread.
     * See {@link #shouldNotFilterAsyncDispatch()} for details.
     * <p>Provides HttpServletRequest and HttpServletResponse arguments instead of the
     * default ServletRequest and ServletResponse ones.
     *
     * @param request
     * @param response
     * @param filterChain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ParameterRequestWrapper changeRequestWrapper = new ParameterRequestWrapper(request);

        filterChain.doFilter(changeRequestWrapper, response);
    }
}
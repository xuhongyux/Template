package com.xiayu.springboot_demo.authorization;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.servlet.Filter;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;


/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2021/1/2 18:02
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true) //拦截器
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    //*********************************SpringBoot中的授权********************************

/*    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()  //表单配置的方式
                .and()
                .authorizeRequests() //开始权限配置
                .antMatchers("/index","/")//使用Ant风格的路径匹配，这里配置匹配 / 和 /index
                .permitAll() //用户可任意访问
                .anyRequest()//匹配所有路径
                .authenticated(); //用户登录后可访问
        http.csrf().disable();
    }*/

/*    @Override
    public void configure(WebSecurity web) throws Exception {
        // 开放的接口
        web.ignoring().antMatchers(
               "/index");
    }*/



    //*********************************SpringCloud中的授权********************************

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 开放的接口
        web.ignoring().antMatchers(
                //开放所有接口
                "/**",
                //登录验证的接口
                "/oauth/check_token","/user/login","/user/loginSms","/user/getLoginValidation","/user/logout","/user/jwt",
                //Swagger的接口
                "/v2/api-docs","/swagger-ui.html#", "/swagger-resources/configuration/ui", "/swagger-resources","/swagger-resources/configuration/security", "/swagger-ui.html","/css/**", "/js/**","/images/**", "/webjars/**", "**/favicon.ico", "/index");
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        //创建一个用户信息
        return new MyUserDetailsUserService();
    }

    //自定义用户
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                .and()
                //STATELESS session设置为无状态
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //设置授权
                .authorizeRequests()
                // 授权访问
                .antMatchers("/user/info").hasAuthority("USER")
                .antMatchers("/user/logout").hasAuthority("USER");
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new MyUserDetailsUserService();
    }
}

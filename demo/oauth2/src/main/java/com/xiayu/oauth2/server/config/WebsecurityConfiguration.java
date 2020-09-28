package com.xiayu.oauth2.server.config;

import com.xiayu.oauth2.server.config.server.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true) //拦截器
public class WebsecurityConfiguration extends WebSecurityConfigurerAdapter {

    //设置默认加密方式
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }


    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        return new UserDetailsServiceImpl();
    }


/*    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义认证与授权
        auth.userDetailsService(userDetailsService());
    }*/




    @Override
    public void configure(WebSecurity web) throws Exception {
        // 将 check_token 暴露出去，否则资源服务器访问时报 403 错误
        web.ignoring().antMatchers("/oauth/check_token");
    }



//             ~~~~~~~~~~~~~~~~~~~~~~~~~~~爱的波浪线~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //信息在内存中
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("userName").password(passwordEncoder().encode("123456")).roles("ADMIN")
                .and()
                .withUser("admin").password(passwordEncoder().encode("123456")).roles("user");

    }
}

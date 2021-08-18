//package com.xiayu.oauth2Service.server.config;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.provider.ClientDetailsService;
//import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
//
//@Configuration
//@EnableAuthorizationServer  //开启认证服务
//public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
//    //注入用于支持 password 模式
//    @Resource
//    private AuthenticationManager authenticationManager;
//
//    @Bean
//    @Primary   //主配置 防止冲突
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource(){
//       return  DataSourceBuilder.create().build();
//    }
//
//    //对客户端进行配置
//    @Bean
//    public TokenStore tokenStore() {
//        // 基于 JDBC 实现，令牌保存到数据
//        return new JdbcTokenStore(dataSource());
//    }
//
//    @Bean
//    public ClientDetailsService jdbcClientDetails() {
//        // 基于 JDBC 实现，需要事先在数据库配置客户端信息
//        return new JdbcClientDetailsService(dataSource());
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        // 设置令牌
//        endpoints.tokenStore(tokenStore());
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        // 读取客户端配置
//        clients.withClientDetails(jdbcClientDetails());
//    }
//
//
//
//
//
//        /*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~爱的波浪线~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//        不连接数据库，内存中模拟用户
//            clients
//                  // 使用内存设置
//                  .inMemory()
//                  // client_id
//                  .withClient("client")
//                  // client_secret
//                  .secret(bCryptPasswordEncoder.encode("secret"))
//                  // 授权类型
//                  .authorizedGrantTypes("authorization_code")
//                  // 授权范围
//                  .scopes("app")
//                  // 注册回调地址
//                  .redirectUris("http://www.funtl.com");*/
//
//
//}

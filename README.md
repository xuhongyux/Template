# Template
总结一些框架的模板
+ JDK 1.8+
+ MAVEN 3.6+

框架中引入了lombok插件

## 项目介绍
整个项目是以微服务的模板来构建，会在其中添加一些其他框架的Demo

## 模块介绍
### commons 
常用的类的集合，工具类，常用实体类等
 + entity 用来放置一些实体类相关的常用的类
 + utils 用来放置一些工具类
### configuration 
微服务的公共配置类
+ swagger2 配置公共的swagger2参数，扫描路径等
###  data 
项目涉及数据库的表格
###  demo 
非分布式项目框架的演示案例
+ oauth2 一个小模板，采用的是授权码模式
### dependencies 
项目依赖版本管理
### gateway 
微服务项目网关
### oauth 
微服务授权服务
### private 
微服务服务提供者
+ user-api 用户相关的服务暴漏的接口
+ user-service 用户相关的服务接口的实现



## 项目使用到的技术
| 技术                       | 说明                                                     |
| :------------------------- | :------------------------------------------------------- |
| Spring Boot                | 新一代 JavaEE 开发标准                                   |
| Spring Cloud Alibaba       | 阿里巴巴基于 Spring Cloud 编程模型的微服务生态           |
| Spring Cloud Alibaba Dubbo | 与 Spring Cloud Alibaba 生态相结合的高性能 Java RPC 框架 |
| Spring Security oAuth2     | 安全认证和授权框架                                       |
| PageHelper                 | MyBatis 分页插件                                         |
| Swagger                    | API 文档生成工具                                         |
| HikariCP                   | 数据库连接池                                             |
| OKHttp3                    | 轻量级网络框架                                           |

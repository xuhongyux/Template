package com.xiayu.filter.registration.configuration;


import com.google.common.base.Predicates;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Description:
 *  Swagger配置
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/9/30 13:34
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    private static String HEAD = "authorization";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.regex("^(?!jwt).*$"))
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }
    private List<ApiKey> securitySchemes() {
        return newArrayList(
                new ApiKey(HEAD, HEAD, "query"));
    }
    private List<SecurityContext> securityContexts() {
        return newArrayList(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!jwt).*$"))
                        .build()
        );
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(
                new SecurityReference(HEAD, authorizationScopes));
    }



    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Template").description("Template项目api文档")
                .termsOfServiceUrl("").version("1.0.0").build();
    }
/*
    @Bean
    public Docket createRestApi() {


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //设置多个扫描包路径
                //.apis(RequestHandlerSelectors.basePackage("com.xiayu.**.controller"))
                .apis(Predicates.or(
                        RequestHandlerSelectors.basePackage("com.xiayu.filter.registration.controller")
                ))
                //.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))  有api注解的
                .paths(PathSelectors.any())
                .build()
                //设置接口默认的请求头
                .globalOperationParameters(defaultHeader())
                ;
    }
*//*    @Bean
    public SecurityScheme apiKey() {
        return new ApiKey("access_token", "accessToken", "header");
    }*//*

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Template").description("Template项目api文档")
                .termsOfServiceUrl("").version("1.0.0").build();
    }

    *//**
     * 设置默认参数 添加
     * @return
     *//*
    private static List<Parameter> defaultHeader() {
        //添加head参数start
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("Authorization").description("token").modelRef(new ModelRef("string")).parameterType("query").required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }*/
}

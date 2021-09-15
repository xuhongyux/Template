package com.xiayu.demo.config;



import com.xiayu.demo.domain.UserPo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2021/1/3 15:49
 */
@Configuration
public class BeanConfiguration {


    @Value("${userpo.name}")
    private String userName;


    @Profile({"dev"})
    @Bean
    public UserPo getProfilesTest_LOCAL() {
        UserPo userPo = new UserPo();
        userPo.setId("测试不同环境加载不同的Bean");
        userPo.setLoginName(userName);
        userPo.setPassword("加载的是本地环境-dev");
        return userPo;
    }

    @Profile({"test"})
    @Bean
    public UserPo getProfilesTest() {
        UserPo userPo = new UserPo();
        userPo.setId("测试不同环境加载不同的Bean");
        userPo.setLoginName(userName);
        userPo.setPassword("加载的是测试环境-test");
        return userPo;
    }

}

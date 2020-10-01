package com.xiayu.oauth;

import com.xiayu.provider.api.UserService;
import com.xiayu.provider.domain.TestUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class OauthApplicationTests {

    @Reference(version ="1.0.0")
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 测试服务间调用
     */
    @Test
    void contextLoads() {
        TestUser user = userService.getUser();
        System.out.println(user.toString());
    }
    @Test
    public void passwordCode(){
        System.out.println(bCryptPasswordEncoder.encode("123456"));
    }

}

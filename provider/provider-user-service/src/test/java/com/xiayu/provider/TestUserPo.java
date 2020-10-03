package com.xiayu.provider;

import com.xiayu.provider.api.UserService;
import com.xiayu.provider.domain.UserPo;
import com.xiayu.provider.params.UserInsertVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/10/3 12:02
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestUserPo {
    @Autowired
    private UserService userService;

    @Test
    public void selectUserByName(){
        UserPo userPo = userService.selectUserByName("user");
        System.out.println(userPo.toString());
    }

    @Test
    public void insertUser(){
        UserInsertVo userInsertVo = new UserInsertVo();
        userInsertVo.setName("夏雨");
        userInsertVo.setPassword("123456");
        userInsertVo.setTel("13164376290");
        userInsertVo.setType(0);
        userService.insert(userInsertVo);

    }

}

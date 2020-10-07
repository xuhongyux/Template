package com.xiayu.provider.jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/10/7 18:36
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Rollback
public class Test {
    @Resource
    private StringEncryptor stringEncryptor;

    @org.junit.Test
    public void possWordCode(){
        String string1 =stringEncryptor.encrypt("test");
        System.out.println(string1);

    }

    private String encrypt(String originPassword){
        String encryptStr = stringEncryptor.encrypt(originPassword);
        return encryptStr;
    }

}

package com.xiayu.springboot_demo;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import javax.annotation.Resource;

@SpringBootTest
class SpringbootDemoApplicationTests {

    @Resource
    public BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringbootDemoApplicationTests springbootDemoApplicationTests = new SpringbootDemoApplicationTests();
        springbootDemoApplicationTests.getEncoder();

    }

    @org.junit.Test
    public void  getEncoder(){
        System.out.println(passwordEncoder.encode("123456"));
    }


/*    public static void main(String[] args) throws UnsupportedEncodingException {
        String decode = URLDecoder.decode("%E5%BE%90%E5%BE%90", "UTF-8");
        System.out.println(decode);
    }*/

}

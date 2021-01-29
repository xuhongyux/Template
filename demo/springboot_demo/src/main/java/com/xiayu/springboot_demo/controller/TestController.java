package com.xiayu.springboot_demo.controller;


import com.xiayu.springboot_demo.annotation.AnnotationTest;
import com.xiayu.springboot_demo.domain.UserPo;
import com.xiayu.springboot_demo.entity.ResponseResult;
import com.xiayu.springboot_demo.mapper.UserMapper;
import com.xiayu.springboot_demo.params.RequestVo;
import com.xiayu.springboot_demo.utils.ImageUtils;
import com.xiayu.springboot_demo.utils.SnowFlakeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @author xuhongyu
 * @describe
 * @create 2020-11-24-14:11
 */
@Api(tags = "测试")
@RestController
@RequestMapping("test/")
public class TestController {




    @Autowired
    private SnowFlakeUtil snowFlakeUtil;

    @Autowired
    private UserPo userPo;

    @Autowired
    private UserMapper userMapper;
//    @Resource
//    public BCryptPasswordEncoder passwordEncoder;

    @GetMapping(value = "annotationTest")
    @ApiOperation("测试注解")
    @AnnotationTest("夏雨")
    public UserPo annotationTest() {
        System.out.println("------------------");
       return new UserPo();
    }
    @GetMapping(value = "log")
    @ApiOperation("测试日志")
    public UserPo log() {
        Log log = LogFactory.getLog(this.getClass());
        log.info("asdf");
        return new UserPo();
    }


    @GetMapping(value = "mybatisMapperTest")
    @ApiOperation("mybatis测试")
    public ResponseResult<String> mybatisMapperTest() {
        UserPo userPo = new UserPo();   
        userPo.setLoginName("夏雨");
        List<UserPo> userPos = userMapper.mapperSelectUser(userPo);
        return new ResponseResult<>(ResponseResult.CodeStatus.OK, "mybatis测试", userPos.toString());
    }



    @PostMapping(value = "getQRCode")
    @ApiOperation("获取二维码")
    public ResponseResult<String> createQRCode(@RequestBody RequestVo content, HttpServletResponse response) {

        String url = ImageUtils.createQRCode(content.getContent(),"content",response);
        return new ResponseResult<String>(ResponseResult.CodeStatus.OK, "获取二维码", url);
    }
    @PreAuthorize("hasRole('user')") //只允许user角色访问
    @ApiOperation("测试雪花算法")
    @GetMapping(value  ="snowFlakeTest")
    public ResponseResult<String> snowFlakeTest() {

        long l = snowFlakeUtil.nextId();
        return new ResponseResult<String>(ResponseResult.CodeStatus.OK, "测试雪花算法",String.valueOf(l));
    }


    @ApiOperation("获取加密数据")
    @GetMapping(value  ="getEncode")
    public ResponseResult<String> getEncode() {
      //  String encode = passwordEncoder.encode("123456");
        return new ResponseResult<String>(ResponseResult.CodeStatus.OK, "获取加密数据",null);
    }


    @ApiOperation("测试不同的profile")
    @GetMapping(value  ="profileTest")
    public ResponseResult<String> profileTest() {
        String s = userPo.toString();
        return new ResponseResult<String>(ResponseResult.CodeStatus.OK, "测试不同的profile",s);
    }


}

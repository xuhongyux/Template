package com.xiayu.springboot_demo.controller;

import com.xiayu.springboot_demo.entity.ResponseResult;
import com.xiayu.springboot_demo.utils.ImageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @author xuhongyu
 * @describe
 * @create 2020-11-24-14:11
 */
@Api(tags = "测试")
@RestController
@RequestMapping("test/")
public class TestController {

    @PostMapping(value = "getQRCode")
    @ApiImplicitParams(
            @ApiImplicitParam()
    )
    @ApiOperation("获取二维码")
    public ResponseResult<String> createQRCode(@RequestParam String content, HttpServletResponse response) {

        String url = ImageUtils.createQRCode(content,"content",response);
        return new ResponseResult<String>(ResponseResult.CodeStatus.OK, "获取二维码", url);
    }
}

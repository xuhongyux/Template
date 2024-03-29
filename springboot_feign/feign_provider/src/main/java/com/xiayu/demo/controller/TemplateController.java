package com.xiayu.demo.controller;


import com.xiayu.demo.entity.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-08-10-2:17 下午
 */
@Slf4j
@RestController(value = "template")
@RequestMapping("template")
@Api(value="template", tags="Controller模板")
public class TemplateController extends  BaseController {


    @ApiOperation(value = "hello", notes = "欢迎接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, paramType = "query", dataType = "String", example = "XiaYu")})
    @GetMapping("/hello")
    public ResponseResult<String> hello(@RequestParam String userName){
        try {
            checkNotNull(userName);
            log.info(userName);
            return new ResponseResult(200,"欢迎接口" ,"hello"+userName);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            return new ResponseResult(500,"欢迎接口" ,"hello"+"userName");
        }
    }

    @ApiOperation(value = "post", notes = "post")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, paramType = "query", dataType = "String", example = "XiaYu")})
    @PostMapping("/post")
    public ResponseResult<String> post(String userName) throws Exception {
        try {
            checkNotNull(userName);
            log.info(userName);
            return new ResponseResult(200,"欢迎接口" ,"hello"+userName);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
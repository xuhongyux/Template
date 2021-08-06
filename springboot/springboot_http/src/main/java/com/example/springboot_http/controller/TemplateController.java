/*
package com.example.springboot_http.controller;

import com.prothentic.data.dto.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

*/
/**
 * @author xuhongyu
 * @create 2021-06-10 11:13
 *//*

@Slf4j
@RestController
@Api(value="/template", tags="Controller模板")
public class TemplateController extends  BaseController {


    @ApiOperation(value = "hello", notes = "欢迎接口")
    @ApiImplicitParams({
             @ApiImplicitParam(name = "userName", value = "用户名", required = true, paramType = "query", dataType = "String", example = "XiaYu")})
    @GetMapping("/hello")
    public BaseResponse<?> hello(@RequestParam String userName){
        try {
            checkNotNull(userName);

            return new BaseResponse<>("OK", "hello"+userName);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            return new BaseResponse<>("ERROR", e.getMessage());
        }
    }
}
*/

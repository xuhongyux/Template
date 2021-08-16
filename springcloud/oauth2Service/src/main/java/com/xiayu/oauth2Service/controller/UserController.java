package com.xiayu.oauth2Service.controller;

import com.google.common.collect.Maps;
import com.xiayu.commons.entity.ResponseResult;
import com.xiayu.commons.utils.JsonUtils;
import com.xiayu.commons.utils.MapperUtils;
import com.xiayu.commons.utils.OkHttpClientUtil;
import com.xiayu.provider.api.UserService;
import com.xiayu.provider.domain.UserPo;
import com.xiayu.provider.params.UserInsertVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import okhttp3.Response;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/9/26 19:46
 */


@Api(value = "Oauth2")
@RestController
@RequestMapping(value = "user/")
public class UserController {

    @Value("${oauth2.grant_type}")
    public String oauth2GrantType;

    @Value("${oauth2.client_secret}")
    public String oauth2ClientSecret;

    @Value("${oauth2.client_id}")
    public String oauth2ClientId;

    @Value("${oauth2.url_oauth}")
    private String urlOauthToken;

    Logger logger = LoggerFactory.getLogger(getClass());


    @Reference(version = "1.0.0")
    private UserService userService;

    @Resource(name = "userDetailsServiceBean")
    public UserDetailsService userDetailsService;

    @Resource
    public BCryptPasswordEncoder passwordEncoder;


    @ApiOperation(value = "获取用户", httpMethod = "GET")
    @GetMapping(value = "/{userName}")
    public ResponseResult getUser(@PathVariable String userName) {
        UserPo user = userService.selectUserByName(userName);
        return new ResponseResult<>(HttpStatus.OK.value(), "获取用户信息", user);

    }

    @ApiOperation(value = "用户登录", httpMethod = "GET")
    @GetMapping(value = "/login")
    public ResponseResult login(String userName, String passWord, HttpServletRequest request) {
        // 封装请求的结果集
        Map<String, Object> result = Maps.newHashMap();

        // 提前校验用户信息
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        if (userDetails == null) {
            return new ResponseResult<>(HttpStatus.OK.value(), "用户信息不存在", result);
        }
        if (userDetails.getUsername().equals("disable")) {
            return new ResponseResult<>(HttpStatus.OK.value(), "用户已被禁用", result);
        }
        if (userDetails == null || !passwordEncoder.matches(passWord, userDetails.getPassword())) {
            return new ResponseResult<>(HttpStatus.OK.value(), "用户名称或者密码错误", result);
        }

        // 通过 HTTP 客户端请求登录接口
        Map<String, String> params = Maps.newHashMap();
        params.put("username", userName);
        params.put("password", passWord);
        params.put("grant_type", oauth2GrantType);
        params.put("client_id", oauth2ClientId);
        params.put("client_secret", oauth2ClientSecret);
        try {
            // 解析响应结果封装并返回
            Response response = OkHttpClientUtil.getInstance().postData(urlOauthToken, params);
            String jsonString = Objects.requireNonNull(response.body()).string();
            Map<String, Object> jsonMap = JsonUtils.json2map(jsonString);
            String token = String.valueOf(jsonMap.get("access_token"));
            //为范围token
            if (MapperUtils.isBlank(token)) {
                return new ResponseResult<>(HttpStatus.OK.value(), null, null);
            }
            result.put("token", token);
            result.put("userName", userName);
            // 发送登录日志

            // 更新最后登录时间

        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(userName + "登录成功", userName);
        return new ResponseResult<>(HttpStatus.OK.value(), "登录成功", result);
    }

    @ApiOperation(value = "用户注册", httpMethod = "POST")
    @PostMapping(value = "/login")
    public ResponseResult<Void> userRegion(@RequestBody UserInsertVo userInsertVo) {
        userService.insert(userInsertVo);
        logger.info(userInsertVo.getName() + "注册成功");
        return new ResponseResult<>(HttpStatus.OK.value(), "注册成功", null);
    }
}

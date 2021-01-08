package com.xiayu.consumers.feignRemote;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author xuhongyu
 * @describe
 * @create 2021-01-07-11:25
 */
@FeignClient("provider-user")
public interface UserFeignRemote {
    @GetMapping(value = "user/selectUserByNameFeign")
    String selectUserByNamefeign();
}

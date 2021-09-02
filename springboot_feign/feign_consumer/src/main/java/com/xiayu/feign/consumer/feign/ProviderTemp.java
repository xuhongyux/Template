package com.xiayu.feign.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-09-02-11:08 上午
 */
@FeignClient("feign-provider")
public interface ProviderTemp {

    /**
     * feign调用
     * @return
     */
    @GetMapping("/template/hello")
    String hello(@RequestParam String userName);



    /**
     * feign调用
     * @return
     */
    @PostMapping("/template/post")
    String post(@RequestParam String userName);
}
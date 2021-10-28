package com.xiayu.http;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xiayu.http.bo.WharfCtnTraceDTO;
import com.xiayu.http.bo.WharfCtnTraceReqDto;
import com.xiayu.http.bo.WharfCtnTraceRes;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;


/**
 * @author xuhongyu
 * @describe
 * @create 2021-10-22-9:48 上午
 */
public class RestTemplateTest {
    public static void main(String[] args) {


        WharfCtnTraceReqDto wharfCtnTraceReqDto = new WharfCtnTraceReqDto();
        wharfCtnTraceReqDto.setBlNo("213391455");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));


        //请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.add(HttpHeaders.ACCEPT, MediaType.ALL_VALUE);
        httpHeaders.add(HttpHeaders.CONNECTION, "keep-alive");
        HttpEntity<WharfCtnTraceReqDto> request = new HttpEntity<>(wharfCtnTraceReqDto, httpHeaders);
        ResponseEntity<String> response;
        try {
            response = restTemplate.postForEntity("https://new.carrierglobe.com/gw/mdm-wct-serve/wharf-ctn-trace/list", request, String.class);


            String body = response.getBody();
            JSONObject jsonObject = JSONObject.parseObject(body);

            JSONArray dataList = jsonObject.getJSONArray("data");
            for (Object o : dataList) {
                JSONObject oJsonObject =  (JSONObject) o;
                WharfCtnTraceRes wharfCtnTraceRes = oJsonObject.toJavaObject(WharfCtnTraceRes.class);
            }

            System.out.println(response);
        }catch (Exception e) {
        }
    }
}
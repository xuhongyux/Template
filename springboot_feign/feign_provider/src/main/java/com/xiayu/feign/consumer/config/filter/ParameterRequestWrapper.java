package com.xiayu.feign.consumer.config.filter;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @description: 类描述：重写 ParameterRequestWrapper
 */

public class ParameterRequestWrapper extends HttpServletRequestWrapper {

    Map<String, String[]> params = new HashMap<String, String[]>();

    private byte[] bytes;

    public ParameterRequestWrapper(HttpServletRequest request) throws IOException {
        // 将request交给父类，以便于调用对应方法的时候，将其输出，其实父亲类的实现方式和第一种new的方式类似
        super(request);
        // 将参数表，赋予给当前的Map以便于持有request中的参数
        this.params.putAll(request.getParameterMap());
        this.modifyParameterValues();
    }


    @Override
    public ServletInputStream getInputStream() throws IOException {
        // 非json类型，直接返回
        String contentType = super.getHeader(HttpHeaders.CONTENT_TYPE);

        // 为空，直接返回
        if (StringUtils.isBlank(contentType)
                || !contentType.toLowerCase().startsWith(MediaType.APPLICATION_JSON_VALUE)) {
            return super.getInputStream();
        }

        bytes = IOUtils.toByteArray(super.getInputStream());
        String json = new String(bytes);
        if (StringUtils.isBlank(json)) {
            return super.getInputStream();
        }
        // body内容是否是json类型
        Boolean jsonFlag = JsonUtil.validateJson(json);
        if (jsonFlag) {
            JSONObject jsonObject = JSONObject.parseObject(json);
            // 裁剪空格
            JSONObject jsonTrim = JsonUtil.jsonStrTrim(jsonObject);

            String processBodyBytes = JSONObject.toJSONString(jsonTrim);
            final ByteArrayInputStream bis = new ByteArrayInputStream(processBodyBytes.getBytes("utf-8"));
            return new ServletInputStream() {
                @Override
                public boolean isFinished() {
                    return true;
                }

                @Override
                public boolean isReady() {
                    return true;
                }

                @Override
                public void setReadListener(ReadListener readListener) {
                }

                @Override
                public int read() {
                    return bis.read();
                }
            };
        }
        ServletInputStream inputStream = super.getInputStream();
        return inputStream;
    }

    /**
     * 将parameter的值去除空格后重写回去
     */
    public void modifyParameterValues() {
        Set<String> set = params.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            String[] values = params.get(key);
            values[0] = values[0].trim();
            params.put(key, values);
        }
    }

    /**
     * 重写getParameter，代表参数从当前类中的map获取
     *
     * @param name
     * @return
     */
    @Override
    public String getParameter(String name) {
        String[] values = params.get(name);
        if (values == null || values.length == 0) {
            return null;
        }
        return values[0];
    }

    @Override
    public String[] getParameterValues(String name) {//同上
        return params.get(name);
    }

}
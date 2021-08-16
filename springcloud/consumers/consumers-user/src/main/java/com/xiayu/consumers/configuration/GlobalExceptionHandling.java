package com.xiayu.consumers.configuration;


import com.xiayu.commons.entity.ResponseResult;
import com.xiayu.commons.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandling {


    /**
     * 处理运行异常
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseResult handleRuntimeException(HttpServletRequest request, RuntimeException ex) {
        log.error("", ex);
        log.error("请求地址：" + request.getRequestURL());
        log.error("请求参数: " + JsonUtils.mapToJson(request.getParameterMap()));
        return  new ResponseResult<Object>(ResponseResult.CodeStatus.UNKNOWN_EXCEPTION,"服务器异常");
    }


    /**
     * 用来捕获404，400这种无法到达controller的错误
     *
     * @param ex
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseResult defaultErrorHandler(Exception ex) throws Exception {
        log.error("", ex);
        ResponseResult<Object> result = new ResponseResult<Object>();
        result.setMessage(ex.getMessage());
        if (ex instanceof NoHandlerFoundException) {
            result.setCode(404);
        } else {
            result.setCode(500);
        }
        result.setData(null);
        result.setCode(ResponseResult.CodeStatus.UNKNOWN_EXCEPTION);
        return result;
    }


}

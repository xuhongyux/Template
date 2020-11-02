package com.xiayu.springboot_demo.exception;



import com.xiayu.springboot_demo.entity.ResponseResult;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException {

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 方法名称
     */
    private final String method;


    /**
     * 自定义异常
     *
     * @param method     方法
     */
    public CustomException( String method) {

        this.code = ResponseResult.CodeStatus.CUSTOM_EXCEPTION;
        this.method = method;
    }

    /**
     * @param code    状态码
     * @param message 错误信息
     * @param method  方法
     */
    public CustomException(Integer code, String message, String method) {
        super(message);
        this.code = code;
        this.method = method;
    }

}

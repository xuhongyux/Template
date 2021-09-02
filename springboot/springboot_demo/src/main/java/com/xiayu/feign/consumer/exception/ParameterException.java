package com.xiayu.feign.consumer.exception;
/**
 * 参数错误
 * @author lijinfeng
 * @date 2021年2月13日
 */

public class ParameterException extends Exception {
	private static final long serialVersionUID = 5012146196937968006L;

	public ParameterException(String message) {
        super(message);
    }

    public ParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}

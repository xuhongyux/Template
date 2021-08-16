package com.xiayu.exception;


import com.xiayu.enums.GeneralErrorCodeEnum;

/**
 * @author xuhongyu
 * @create 2021-06-05 9:38
 */
public class PlatformException extends Exception {

	private static final long serialVersionUID = -116171882575447126L;
	private GeneralErrorCodeEnum errorCode;

    public PlatformException() {
        super();
    }


    public PlatformException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


	public PlatformException(GeneralErrorCodeEnum errorCode) {
        this.errorCode = errorCode;
    }

    public PlatformException(String message, GeneralErrorCodeEnum errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public PlatformException(String message, Throwable cause, GeneralErrorCodeEnum errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public PlatformException(Throwable cause, GeneralErrorCodeEnum errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

	public GeneralErrorCodeEnum getErrorCode() {
        return errorCode;
    }
}

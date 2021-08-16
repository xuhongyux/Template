package com.xiayu.exception;

/**
 * 文件相关错误
 * @author lijinfeng
 * @date 2021年2月13日
 */
public class FileException extends Exception{

	private static final long serialVersionUID = -5459929974481159490L;

	public FileException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FileException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FileException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}

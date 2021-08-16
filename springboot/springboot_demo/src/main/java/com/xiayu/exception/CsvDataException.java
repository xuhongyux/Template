package com.xiayu.exception;


/**
 * @author xuhongyu
 * @create 2021-06-05 9:38
 */

public class CsvDataException extends Exception{
	/**
	 *
	 */
	private static final long serialVersionUID = 2273223363929630341L;

	public CsvDataException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CsvDataException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CsvDataException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}

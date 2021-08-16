package com.xiayu.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 @describe
 @author xuhongyu
 @create 2021-08-10-2:21 下午
 */

public enum GeneralErrorCodeEnum {
    GENERAL(2),
    AUTHENTICATION(10),
    PERMISSION_DENIED(20),
    INVALID_ARGUMENTS(30),
    BAD_REQUEST_PARAMS(31),
    ITEM_NOT_FOUND(32),
    ILLEGAL_OPERATION(33),
    USERNAME_ALREADY_EXISTS(40),
    EMAIL_ALREADY_EXISTS(41),
    JSON_DATA_NOT_RECOGNIZED(50),
    JSON_DATA_GENERATE_ERROR(51),
	CSV_DATA_EMPTY(52),
	FILE_NOT_FOUND(53),
	DATA_SIZE_NOT_EQUAL(54),
	FILE_UPLOAD_ERROR(55),
	CSV_DATA_ERROR(56);

	private int errorCode;

    GeneralErrorCodeEnum(int errorCode){
		this.errorCode = errorCode;
	}

	@JsonValue
    public int getErrorCode() {
        return errorCode;
    }
}

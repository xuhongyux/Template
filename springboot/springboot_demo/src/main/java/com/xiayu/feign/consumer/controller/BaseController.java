package com.xiayu.feign.consumer.controller;


import com.xiayu.feign.consumer.enums.GeneralErrorCodeEnum;
import com.xiayu.feign.consumer.exception.CsvDataException;
import com.xiayu.feign.consumer.exception.DataMatchException;
import com.xiayu.feign.consumer.exception.FileException;
import com.xiayu.feign.consumer.exception.ParameterException;
import com.xiayu.feign.consumer.exception.PlatformException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-08-10-2:16 下午
 */
@Slf4j
@ApiIgnore
public class BaseController {

    protected final static String USER_ID = "userId";

    public static final String NULL_UUID = "13814000-1dd2-11b2-8080-808080808080";
    protected static final String OPEN_PAREN = new String("(");
    protected static final String CLOSE_PAREN = new String(")");
    protected static final String OPEN_PAREN_REG = new String("\\(");
    protected static final String CLOSE_PAREN_REG = new String("\\)");

    PlatformException handleException(Exception exception) {
        return handleException(exception, true);
    }

    /**
     * 所有exception的处理类型在这里定义
     * @param
     * @return
     * @throws
     */
    private PlatformException handleException(Exception exception, boolean logException) {
        if (logException) {
            log.error("Error [{}]", exception.getMessage());
        }

        String cause = "";
        if (exception.getCause() != null) {
            cause = exception.getCause().getClass().getCanonicalName();
        }

        if (exception instanceof PlatformException) {
            return (PlatformException) exception;
        }
        else if (exception instanceof IllegalArgumentException || exception instanceof ParameterException
                || cause.contains("ParameterException")) {
            return new PlatformException(exception.getMessage(), GeneralErrorCodeEnum.BAD_REQUEST_PARAMS);
        }
        else if (exception instanceof IOException) {
            return new PlatformException(exception.getMessage(), GeneralErrorCodeEnum.FILE_NOT_FOUND);
        }
        else if (exception instanceof DataMatchException) {
            return new PlatformException(exception.getMessage(), GeneralErrorCodeEnum.DATA_SIZE_NOT_EQUAL);
        }
        else if (exception instanceof FileException) {
            return new PlatformException(exception.getMessage(), GeneralErrorCodeEnum.FILE_UPLOAD_ERROR);
        }
        else if (exception instanceof CsvDataException) {
            return new PlatformException(exception.getMessage(), GeneralErrorCodeEnum.CSV_DATA_ERROR);
        }
        else {
            return new PlatformException(exception.getMessage(), GeneralErrorCodeEnum.GENERAL);
        }
    }



    <T> T checkNotNull(T reference) throws PlatformException {
        if (reference == null) {
            throw new PlatformException("Requested item wasn't found!", GeneralErrorCodeEnum.ITEM_NOT_FOUND);
        }
        return reference;
    }

    <T> T checkNotNull(Optional<T> reference) throws PlatformException {
        if (reference.isPresent()) {
            return reference.get();
        } else {
            throw new PlatformException("Requested item wasn't found!", GeneralErrorCodeEnum.ITEM_NOT_FOUND);
        }
    }


    /**
     * 检查参数是否为空
     *
     * @param name
     * @param param
     * @throws PlatformException
     */
    void checkParameter(String name, String param) throws PlatformException {
        if (StringUtils.isEmpty(param)) {
            throw new PlatformException("Parameter '" + name + "' can't be empty!", GeneralErrorCodeEnum.BAD_REQUEST_PARAMS);
        }
    }

    protected String constructBaseUrl(HttpServletRequest request) {
        String scheme = request.getScheme();
        if (request.getHeader("x-forwarded-proto") != null) {
            scheme = request.getHeader("x-forwarded-proto");
        }
        int serverPort = request.getServerPort();
        if (request.getHeader("x-forwarded-port") != null) {
            try {
                serverPort = request.getIntHeader("x-forwarded-port");
            } catch (NumberFormatException e) {
            }
        }

        String baseUrl = String.format("%s://%s:%d",
                scheme,
                request.getServerName(),
                serverPort);
        return baseUrl;
    }
}

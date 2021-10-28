package com.xiayu.http.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 码头箱货跟踪请求对象
 * @author lihao
 */
@Data
public class WharfCtnTraceReqDto implements Serializable {
    private static final long serialVersionUID = -447245298256729880L;

    /**提单号*/
    private String blNo;
    /**箱号*/
    private String ctnNo;
    /**港口code*/
    private String portCode;
    /**码头code*/
    private String wharfCode;
}

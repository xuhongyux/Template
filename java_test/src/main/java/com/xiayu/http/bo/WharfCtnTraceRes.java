package com.xiayu.http.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author lihao
 * @date 2021-09-07 18:23
 */
@Data
public class WharfCtnTraceRes implements Serializable {
    private static final long serialVersionUID = 5266979179434335712L;

    private String portCode;
    private String ieType;
    private String voyage;
    private String blNo;
    private String ctnNo;
    private List<WharfCtnTraceDTO> traceNodeList;
}

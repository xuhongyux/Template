package com.xiayu.work;

//import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Base64;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-01-12-10:51
 */
@Data
public class RiskLevelButtonVo implements Cloneable {
   // @ApiModelProperty(value = "操作人工号", required = true)
    private String operatorCode;

  //  @ApiModelProperty(value = "操作员所在机构代码", required = true)
    private String comCode;

    //@ApiModelProperty(value = "客户代码", required = true)
    private String clientCode;

  //  @ApiModelProperty(value = "交易币种【0：人民币；1：其他】", required = true)
    private String currency;

  //  @ApiModelProperty(value = "交易方式【0:银行转账、其他; 1:现金】", required = false)
    private String payType;

   // @ApiModelProperty(value = "保单号", required = true)
    private String policyNo;

//    @ApiModelProperty(value = "赔案号", required = true)
    private String claimNo;

  //  @ApiModelProperty(value = "报案号", required = true)
    private String registNo;

    /**
     * 系统代码-CNLP：非车理赔
     */
    private static String system = "CNLP";


    private static String PREFIX = "?qcarText=";
    private static String SUFFIX = "Base64.encode(paramStr).replace(/\\r/g,\"\").replace(/\\n/g,\"\").replace(/\\+/g,\"%2B\")";

    @Override
    public Object clone() throws CloneNotSupportedException {
        RiskLevelButtonVo newStu = (RiskLevelButtonVo) super.clone();
        return newStu;
    }
    @Override
    public String toString() {
        return "operatorCode=" + this.operatorCode + "&comCode=" + this.comCode + "&clientCode=" + this.clientCode
                + "&currency=" + this.currency
                + "&payType=" + this.payType
                + "&system=" + system
                + "&policyNo=" + this.policyNo + "&claimNo=" + this.claimNo + "&registNo=" + this.registNo;
    }

    public String toStringBase64() {
        String str = toString();
        byte[] bytes = str.getBytes();
        String s = Base64.getEncoder().encodeToString(bytes);
        System.out.println(s);
        String encode = PREFIX + Base64.getEncoder().encodeToString(bytes) ;
        return encode;
    }


}

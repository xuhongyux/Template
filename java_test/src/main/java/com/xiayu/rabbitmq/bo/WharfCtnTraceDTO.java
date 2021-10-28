package com.xiayu.rabbitmq.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author lihao
 * @date 2021-09-07 17:55
 */
@Data
public class WharfCtnTraceDTO implements Serializable {
    private static final long serialVersionUID = 5266979179434335712L;

    @ApiModelProperty(value = "港口code")
    private String portCode;

    @ApiModelProperty(value = "提单号")
    private String blNo;

    @ApiModelProperty(value = "箱号")
    private String ctnNo;

    @ApiModelProperty(value = "船名")
    private String vessel;

    @ApiModelProperty(value = "航次")
    private String voyage;

    @ApiModelProperty(value = "进出口")
    private String ieType;

    @ApiModelProperty(value = "码头code")
    private String wharfCode;

    @ApiModelProperty(value = "码头名称")
    private String wharfName;

    @ApiModelProperty(value = "节点代码")
    private String traceNodeCode;

    @ApiModelProperty(value = "节点中文名称")
    private String traceNodeName;

    @ApiModelProperty(value = "节点发生时间")
    private LocalDateTime eventTime;

    @ApiModelProperty(value = "节点附加数据")
    private String nodeInfo;
}

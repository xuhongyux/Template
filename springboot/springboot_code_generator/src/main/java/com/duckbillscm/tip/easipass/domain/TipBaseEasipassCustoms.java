package com.duckbillscm.tip.easipass.domain;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 报关信息表
 * </p>
 *
 * @author xuhongyu
 * @since 2021-09-16
 */
@Data
@ApiModel(value="TipBaseEasipassCustoms对象", description="报关信息表")
public class TipBaseEasipassCustoms  {

    private static final long serialVersionUID = 1L;

    private String createBy;

    private LocalDateTime createTime;

    private LocalDateTime updatedTime;

    @ApiModelProperty(value = "逻辑删除字段 0 默认值 未删除 1 已删除")
    private Boolean deleted;

    @ApiModelProperty(value = "0 已经订阅，1 已经报关")
    private String customsState;

    @ApiModelProperty(value = "航次")
    private String voyage;

    @ApiModelProperty(value = "提单号")
    private String blNo;

    @ApiModelProperty(value = "预录入编号")
    private String entryNo;

    @ApiModelProperty(value = "运输工具代码及编号")
    private String vslName;

    @ApiModelProperty(value = "源最新业务交易时间")
    private String lastUpdateDdt;


}

package com.xiayu.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 自增 id
     */
    @TableId(value = "id", type = IdType.AUTO)
    String id;

    /**
     * 数据版本
     */
    @Version
    Long version = 0L;

    /**
     * 创建人id
     */
    @TableField(fill = FieldFill.INSERT,value = "created_by")
    String createdBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT,value = "creation_time")
    LocalDateTime createdTime;

    /**
     * 更新人id
     */
    @TableField(fill = FieldFill.INSERT_UPDATE,value = "updated_by")
    String updatedBy;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE,value = "last_update_time")
    LocalDateTime updatedTime;

//    /**
//     * 逻辑删除
//     */
//    @TableLogic
//    Integer deleted;

}

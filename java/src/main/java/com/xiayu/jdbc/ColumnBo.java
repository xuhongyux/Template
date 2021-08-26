package com.xiayu.jdbc;

import lombok.Data;

/**
 * @author xuhongyu
 * @create 2021-06-21 15:49
 */

public class ColumnBo {
    /**
     * 属性的类型名称
     */
    String columnTypeName;

    /**
     * 属性名称
     */
    String columnName;

    /**
     * 时间精度
     */
    Integer precision;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public String getColumnTypeName() {
        return columnTypeName;
    }

    public void setColumnTypeName(String columnTypeName) {
        this.columnTypeName = columnTypeName;

    }

    @Override
    public String toString() {
        if (columnTypeName.equals("DATETIME")) {
            return this.columnName + " " + this.columnTypeName + " ";
        }else {
            return this.columnName + " " + this.columnTypeName + " ("+this.precision+") ";
        }
    }
}

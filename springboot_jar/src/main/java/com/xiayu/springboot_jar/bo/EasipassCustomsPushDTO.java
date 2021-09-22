package com.xiayu.springboot_jar.bo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @author xuhongyu
 * @describe 亿通报关消息推送接口
 * @create 2021-09-14-3:22 下午
 */
@Data
@ApiModel
public class EasipassCustomsPushDTO {

    private Data data;
    private String info;
    private String flag;

    @lombok.Data
    public static class DataLists {

        private String rspCode;
        private String rspText;
        private String voyage;
        private String blNo;
        private String entryNo;
        private String vslName;
        private Object lastupdateddt;
    }

    public static class Data {


        private String dataKey;
        private List<DataLists> dataList;
        public void setDataKey(String dataKey) {
            this.dataKey = dataKey;
        }
        public String getDataKey() {
            return dataKey;
        }

        public void setDataList(List<DataLists> dataList) {
            this.dataList = dataList;
        }
        public List<DataLists> getDataList() {
            return dataList;
        }
    }

}
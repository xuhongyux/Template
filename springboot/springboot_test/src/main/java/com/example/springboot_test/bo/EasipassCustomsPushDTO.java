package com.example.springboot_test.bo;

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
    public void setData(Data data) {
        this.data = data;
    }
    public Data getData() {
        return data;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    public String getInfo() {
        return info;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
    public String getFlag() {
        return flag;
    }

    public class DataList {

        private String rspCode;
        private String rspText;
        private String voyage;
        private String blNo;
        private String entryNo;
        private String vslName;
        private String lastupdateddt;

        public void setRspCode(String rspCode) {
            this.rspCode = rspCode;
        }

        public String getRspCode() {
            return rspCode;
        }

        public void setRspText(String rspText) {
            this.rspText = rspText;
        }

        public String getRspText() {
            return rspText;
        }

        public void setVoyage(String voyage) {
            this.voyage = voyage;
        }

        public String getVoyage() {
            return voyage;
        }

        public void setBlNo(String blNo) {
            this.blNo = blNo;
        }

        public String getBlNo() {
            return blNo;
        }

        public void setEntryNo(String entryNo) {
            this.entryNo = entryNo;
        }

        public String getEntryNo() {
            return entryNo;
        }

        public void setVslName(String vslName) {
            this.vslName = vslName;
        }

        public String getVslName() {
            return vslName;
        }

        public void setLastupdateddt(String lastupdateddt) {
            this.lastupdateddt = lastupdateddt;
        }

        public String getLastupdateddt() {
            return lastupdateddt;
        }
    }

    public class Data {
        private String dataKey;
        private List<DataList> dataList;
        public void setDataKey(String dataKey) {
            this.dataKey = dataKey;
        }
        public String getDataKey() {
            return dataKey;
        }

        public void setDataList(List<DataList> dataList) {
            this.dataList = dataList;
        }
        public List<DataList> getDataList() {
            return dataList;
        }
    }

}
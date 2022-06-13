package com.xiayu.email.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-09-16-1:47 下午
 */
@Data
public class EasipassCustomsPushDataDTO implements Serializable {
    private String dataKey;
    private List<EasipassCustomsPushDataListDTO> dataList;
}
package com.xiayu.readfile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.File;

/**
 * @author xuhongyu
 * @create 2021-07-14 16:55
 */
public class WorkTest {
    public static void main(String[] args) {
        WorkTest workTest = new WorkTest();
        String content = "{\"status\":\"OK\",\"code\":50001,\"content\":{\"result\":{\"analyticsData\":[{\"dimensionItem\":[\"全部\"],\"currentKpiValue\":[\"17662\"],\"previousKpiValue\":[\"18081\"]}],\"maxCurrentKpiValue\":[17662.0],\"maxPreviousKpiValue\":[18081.0],\"dimensionLong\":[4],\"dimensionValueType\":null},\"resultTitle\":null,\"resultType\":1,\"functionName\":[\"案例数量\"],\"contents\":[\"KPI(CASE_COUNT())\"],\"dimensionValueType\":[\"string\"]}}";
        Object contentObject = JSONObject.parse(content);
        String processId = "1";
        String userGroup = "xy";

        InitCustomResultBo initCustomResultBo = new InitCustomResultBo();

        initCustomResultBo.setKpiId(121231231231231313L);
        initCustomResultBo.setFunctionName("");
        initCustomResultBo.setLabel("");
        initCustomResultBo.setSaveResult(contentObject);
        initCustomResultBo.setDateFilterCondition("");
        initCustomResultBo.setFilterCondition("");

        workTest.saveInitCustomResult(processId,userGroup,initCustomResultBo);

        Object initCustomPermutationKpiResult = workTest.getInitCustomPermutationKpiResult(processId, userGroup, initCustomResultBo);
        System.out.println();
    }
    public void saveInitCustomResult(String processId, String userGroup, InitCustomResultBo initCustomResultBo){
        Object saveResult = initCustomResultBo.getSaveResult();
        Long kpiId = initCustomResultBo.getKpiId();
        String functionName = initCustomResultBo.getFunctionName();
        String label = initCustomResultBo.getLabel();
        String content = JSONObject.toJSONString(saveResult);
        // todo custom 表盘缓存的路径问题
        String path = userGroup+ processId;
        StringBuilder fileName = new StringBuilder();
        if(kpiId != null && kpiId != 0){
            fileName.append(kpiId);
        }else {
            fileName.append(functionName);
            fileName.append(label);
        }
        fileName.append(".csv");

        FileUtil.makeDir(path);
        File file = FileUtil.createFile(initCustomResultBo.getPath()+"\\"+path, fileName.toString());
        FileUtil.writeToFile(file,content);

    }


    public Object getInitCustomPermutationKpiResult(String processId, String userGroup, InitCustomResultBo initCustomResultBo) {
        // todo custom 表盘缓存 的路径问题
        Long kpiId = initCustomResultBo.getKpiId();
        String functionName = initCustomResultBo.getFunctionName();
        String label = initCustomResultBo.getLabel();
        String path = userGroup+ processId;
        StringBuilder fileName = new StringBuilder();
        if(kpiId != null && kpiId != 0){
            fileName.append(kpiId);
        }else {
            fileName.append(functionName);
            fileName.append(label);
        }
        fileName.append(".csv");
        File file = FileUtil.createNewFile(initCustomResultBo.getPath()+"\\"+path, fileName.toString());
        String readContent = FileUtil.readFile(file);
        Object parse = JSON.parse(readContent);

        return parse;
    }
}

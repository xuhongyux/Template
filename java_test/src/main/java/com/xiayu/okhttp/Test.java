package com.xiayu.okhttp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xiayu.readfile.FileUtil;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongyu
 * @describe ok http
 * @create 2021-09-04-4:02 下午
 */
public class Test {
//    // aft环境
//    StringBuilder aftUrl = new StringBuilder();
//        aftUrl.append("http://new.fat.driverglobe.com/ws-truck/truck_audit/container/match?");
//        aftUrl.append("id=");
//        aftUrl.append("1460606");
//        aftUrl.append("&passType=true&_=");
//        aftUrl.append("1630742769974");

    public static void main(String[] args) {

        OkHttpClient okHttpClient = new OkHttpClient();
        String aftCookie = "SESSION=b000882b-663a-4bfe-b284-d270be99bfa5; Hm_lvt_565e591bdb40c562966b267b3dbe5f82=1630314036,1630718653; Hm_lpvt_565e591bdb40c562966b267b3dbe5f82=1630741139; acw_tc=2f624a0216307432288485860e0932904f7a3fdfdd3cfc98f21906b97fa4ff";

        List<String> ids = getIds();
        List<String> objects = new ArrayList<>();
        objects.add("1881811");
        for (String id : ids) {
            // 正式环境
            StringBuilder url = new StringBuilder();
            url.append("https://new.carrierglobe.com/ws-truck/truck_audit/container/match?");
            url.append("id=");
            url.append(id);
            url.append("&passType=true&_=");
            url.append("1630741139178");
            Request request = new Request.Builder()
                    .url(url.toString())
                    .get()
                    .addHeader("Cookie", aftCookie)
                    .build();
            Call call = okHttpClient.newCall(request);
            try {
                Response response = call.execute();
                System.out.println(response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @org.junit.Test
    public void test() {
        matchInformation("1888098");
    }


    public static List<String> getIds() {
        File file = new File("/Users/xiayu/临时文件/xiayu.json");
        String jsonString = FileUtil.readFile(file);
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        JSONArray containers = (JSONArray) jsonObject.get("containers");

        List<String> ids = new ArrayList<>();
        for (Object container : containers) {
            JSONObject containerObject = (JSONObject) container;
            Object id = containerObject.get("id");


            // 开始规则校验
            // 校验提箱号长度是否正常  -7位
            Object blNo = containerObject.get("blNo");
            if (blNo.toString().length() < 7) {
                ids.add(id.toString());
                continue;
            }


        }
        return ids;
    }


    public static Object matchInformation(String id) {
        OkHttpClient okHttpClient = new OkHttpClient();
        String aftCookie = "SESSION=b000882b-663a-4bfe-b284-d270be99bfa5; Hm_lvt_565e591bdb40c562966b267b3dbe5f82=1630314036,1630718653; Hm_lpvt_565e591bdb40c562966b267b3dbe5f82=1630741139; acw_tc=2f624a0216307432288485860e0932904f7a3fdfdd3cfc98f21906b97fa4ff";


        // 正式环境
        StringBuilder url = new StringBuilder();
        url.append("https://new.carrierglobe.com/ws-truck/order/container/matchInformation?");
        url.append("id=");
        url.append(id);
        url.append("&passType=true&_=");
        url.append("1630741139178");
        Request request = new Request.Builder()
                .url(url.toString())
                .get()
                .addHeader("Cookie", aftCookie)
                .build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();

            String StringTemp = response.body().string();
            JSONObject jsonObjectTemp = (JSONObject) JSONObject.parse(StringTemp);

            // 获取 预录信息
            JSONObject receiptDto = (JSONObject) jsonObjectTemp.get("receiptDto");

            // 获取 订单信息
            JSONObject containerDto = (JSONObject) jsonObjectTemp.get("containerDto");

            // 箱号
            Object containerNoRec = receiptDto.get("containerNo");
            Object containerNoCon = containerDto.get("containerNo");
            if (containerNoRec == null || containerNoCon ==null ) {
                return false;
            }
            if(!containerNoRec.toString().equals(containerNoCon.toString()) ){
                return false;
            }
            // 封号
            Object sealNoRec = receiptDto.get("sealNo");
            Object sealNoCon = containerDto.get("sealNo");

            if(sealNoRec == null || sealNoCon == null){
                return false;
            }
            if(!sealNoRec.toString().equals(sealNoCon.toString())){
                return false;
            }

            // 船名
            receiptDto.get("");



            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
package com.xiayu.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-09-10-4:56 下午
 */
public class Test {
    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static final String CONTENT_TYPE = "application/json";
    public static String REQUEST_METHOD = "POST";
    public static String mockPrefix = "https://uat.eptrade.cn/mock/18";//测试地址(无需授权码)
    public static String actualPrefix = "https://api.eptrade.cn";//⽣产地址
    public static String mappingUrl = "/subscribe/v1/userService/saveSubscribeInfo";//映射路径
    /**
     * 需要配置的参数
     */
    //授权码,调用生产地址必须填写
    public static String AUTHORIZATION = "xxxxxxxxxxxxxxx";
    // 请求参数，json格式
    public static String params = "{\n" +
            " \"dataKey\": \"7144_1.1_1\",\n" +
            " \"extMap\": {\n" +
            " \"blNo\": \"ONEYSH9AQ5570311\"\n" +
            " },\n" +
            " \"modeType\": \"6\",\n" +
            " \"pushIp\": \"http://**********/*****\",\n" +
            " \"taskKey\": \"sub00011\",\n" +
            " \"orgCode\": \"88900877\",\n" +
            " \"sendType\": \"1\",\n" +
            " \"appCode\": \"BIGDATA_APIS\"\n" +
            "}";

    /**
     * 发送请求
     */

    public static void main(String[] args) {
        try {
            //调测试
            String testUrl = mockPrefix + mappingUrl;
            // 调生产，需修改AUTHORIZATION值为实际的AUTHORIZATION
            // String testUrl =actualPrefix+mappingUrl;
            String result = net(testUrl, params, REQUEST_METHOD);
            System.out.println("result = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String net(String strUrl, String params, String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            if (method == null || method.equals("GET")) {
                strUrl = strUrl + "?" + params;
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if (method == null || method.equals("GET")) {
                conn.setRequestMethod("GET");
            } else {
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("Content-Type", CONTENT_TYPE);
            conn.setRequestProperty("Authorization", AUTHORIZATION);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params != null && method.equals("POST")) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(params);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;

    }
}
package com.xiayu.http;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author xuhongyu
 * @create 2021-11-25 1:25 下午
 */
public class HttpPostTest {

    public static void main(String[] args) throws IOException {
        String url="http://222.128.103.144:8101/get_pdf_json_trust_letter";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        String fileUrl = "http://fastdfs.driverglobe.com/group1/M00/10/A0/Ch7o6lpF7vSAWlnNAACeAHa8R8Q491.doc";
        String[] split = fileUrl.split("/.");
        String fileName = split[split.length-1];
        String saveDir = "/Users/临时文件";

        File file = new File(saveDir + "/" + fileName);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();

        try {
            //转换成文件流
            ContentType contentType = ContentType.create("multipart/form-data", Consts.UTF_8);
            builder.addBinaryBody("file", file);
            builder.addTextBody("file_name", fileName,  ContentType.create("text/plain", Consts.UTF_8));

            builder.setContentType(contentType);
        } catch (Exception e) {

        }
        HttpEntity build = builder.build();
        httpPost.setEntity(build);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String responseContent = EntityUtils.toString(entity, "UTF-8");
        System.out.println(responseContent);
        response.close();
        httpClient.close();
    }
}

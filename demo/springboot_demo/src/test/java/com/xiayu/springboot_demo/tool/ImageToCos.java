package com.xiayu.springboot_demo.tool;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.transfer.Transfer;
import com.qcloud.cos.transfer.TransferManager;
import com.qcloud.cos.transfer.Upload;
import com.xiayu.springboot_demo.utils.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/11/10 20:26
 */
public class ImageToCos {


    public static String BUCKETNAME = "image-1259671659";


//    //图片存放位置

    // 1 初始化用户身份信息（secretId, secretKey）。
    public static String secretId = "AKIDAAxZd0v4wj5GG3uEZiqlSvwjHZbSYhRv";
    public static String secretKey = "Sf6cVJUTOAxXqx78wVorhHeliRxCCzcs";

    public static void main(String[] args) {
        String url = "C:\\Users\\xiayu\\Desktop\\current\\上传图标";
       // contextLoads(url, "image/头像/");
        contextLoads(url, "image/图标/");
    }

    /**
     * 上传图片
     *
     * @param folderPath 本地问价夹路径
     */
    public static void contextLoads(String folderPath, String cosKeyPrefix) {
        // 1 设置凭证
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置bucket的地域简称(参照下图)
        Region region = new Region("ap-shanghai");
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        // bucket名需包含appid
        ExecutorService threadPool = Executors.newCachedThreadPool();

        // 传入一个threadpool, 若不传入线程池, 默认TransferManager中会生成一个单线程的线程池。
        TransferManager transferManager = new TransferManager(cosclient, threadPool);

        ArrayList<Object> objects = FileUtil.scanFilesWithRecursion(folderPath);
        Map<String, File> hashMap = new HashMap<>();
        for (Object object : objects) {
            File localFile = new File(object.toString());
            String cosKey = cosKeyPrefix + localFile.getName();
            hashMap.put(cosKey,localFile);
        }
        try {
            Upload upload =null;
            // 返回一个异步结果Upload, 可同步的调用waitForUploadResult等待upload结束, 成功返回UploadResult, 失败抛出异常.
            for (Map.Entry<String,File> map : hashMap.entrySet()) {
                upload = transferManager.upload( new PutObjectRequest(BUCKETNAME,map.getKey(),map.getValue()));
                showTransferProgress(upload);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        transferManager.shutdownNow();
        cosclient.shutdown();
        System.out.println("上传完成");
    }

    private static void showTransferProgress(Transfer transfer) {
        do {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return;
            }
        } while (transfer.isDone() == false);
    }

}

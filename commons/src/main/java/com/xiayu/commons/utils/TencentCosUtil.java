package com.xiayu.commons.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.transfer.Transfer;
import com.qcloud.cos.transfer.TransferManager;
import com.qcloud.cos.transfer.Upload;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2020/5/2 13:52
 */
public class TencentCosUtil {


    public static String BUCKETNAME ="reborn-1259671659";

//    //图片存放位置
//    public String imagePaty = "D:\\IDEA_work3\\reborn-tutor\\avatar_image";

    // 1 初始化用户身份信息（secretId, secretKey）。
    public static String secretId = "AKIDAAxZd0v4wj5GG3uEZiqlSvwjHZbSYhRv";
    public static String secretKey = "Sf6cVJUTOAxXqx78wVorhHeliRxCCzcs";

    // //本地文件路径
    //        String fileUrl="C:\\Users\\xiayu\\Desktop\\图片.jpg";
    //cos文件路径
    //String key = "test\\tupoan.jpg";

    /**
     * 上传图片
     * @param fileUrl 本地图片地址
     * @param cosKey  cosKey
     */
    public static void contextLoads(String fileUrl,String cosKey) {

        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 设置bucket的地域简称(参照下图)
        Region region = new Region("ap-chengdu");
        ClientConfig clientConfig = new ClientConfig(region);
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        // bucket名需包含appid
        ExecutorService threadPool = Executors.newCachedThreadPool();

        // 传入一个threadpool, 若不传入线程池, 默认TransferManager中会生成一个单线程的线程池。
        TransferManager transferManager = new TransferManager(cosclient, threadPool);

        File localFile = new File(fileUrl);

        PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKETNAME, cosKey, localFile);
        try {
            // 返回一个异步结果Upload, 可同步的调用waitForUploadResult等待upload结束, 成功返回UploadResult, 失败抛出异常.
            Upload upload = transferManager.upload(putObjectRequest);
            showTransferProgress(upload);
        } catch (Exception e) {
            e.printStackTrace();
        }
        transferManager.shutdownNow();
        cosclient.shutdown();
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

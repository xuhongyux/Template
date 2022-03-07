package com.xiayu.http;

import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;
import com.obs.services.model.AccessControlList;
import com.obs.services.model.DeleteObjectResult;
import com.obs.services.model.HeaderResponse;
import com.obs.services.model.HttpMethodEnum;
import com.obs.services.model.ListObjectsRequest;
import com.obs.services.model.ObjectListing;
import com.obs.services.model.ObjectMetadata;
import com.obs.services.model.ObsObject;
import com.obs.services.model.PutObjectResult;
import com.obs.services.model.S3Bucket;
import com.obs.services.model.TemporarySignatureRequest;
import com.obs.services.model.TemporarySignatureResponse;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 华为云对象存储
 *
 * @author xuhongyu
 * @create 2022-03-01 5:29 下午
 */
@Data
public class ObsUtils {


    private String accessKeyId = "40FZBDPVDV6L7SE6RDTT";


    private String accessKeySecret = "08eHNDGKlUcz1zNrdWPCVstt7KbuXH7kjcr6uKE3";


    /**
     * 华为云连接的地址节点
     */
    private String endpoint = "obs.cn-east-3.myhuaweicloud.com";


    /**
     * 创建的桶的名称
     */
    private String obsBucketName = "xiayu";

    /**
     * 访问OBS文件的url
     */
    private String url = "xiayu.obs.cn-east-3.myhuaweicloud.com";


    /**
     * 进行操作的华为云的客户端组件
     */
    private static ObsClient obsClient;


    public ObsUtils() {

    }

    /**
     * 创建华为云OBS的本地控制器
     *
     * @param accessKeyId
     * @param accessKeySecret
     * @param endpoint
     */
    public ObsUtils(String accessKeyId, String accessKeySecret, String endpoint) {
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.endpoint = endpoint;
    }

    public ObsUtils(String accessKeyId, String accessKeySecret, String endpoint, String obsBucketName) {
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.endpoint = endpoint;
        this.obsBucketName = obsBucketName;
    }

    /**
     * 获取华为云提供的操作客户端实体类
     *
     * @return
     */
    public ObsClient getObsClient() {
        if (obsClient == null) {
            obsClient = new ObsClient(accessKeyId, accessKeySecret, endpoint);
        }
        return obsClient;
    }

    /**
     * 下载ObsObject
     *
     * @param bucketName 操作的桶的名称 例："wangmarket1232311"
     * @param filePath   需要下载的文件路径。 例："site/a.txt"
     * @return 下载文件的字节数组
     * @throws IOException
     */
    public byte[] getFileByteArray(String bucketName, String filePath) throws IOException {
        ObsObject obsObject = getObsClient().getObject(bucketName, filePath);
        InputStream input = obsObject.getObjectContent();
        byte[] b = new byte[1024];
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int len;
        while ((len = input.read(b)) != -1) {
            bos.write(b, 0, len);
        }
        bos.close();
        input.close();
        return bos.toByteArray();
    }

    /**
     * 获取指定路径下的ObsObject数量
     *
     * @param bucketName 操作的桶的名称 例："wangmarket1232311"
     * @param filePath   需要检索的文件夹路径 例："site/"
     * @return 检索搜文件下的ObsObject的数量
     */
    public Integer getFolderObjectsSize(String bucketName, String filePath) {
        ListObjectsRequest request = new ListObjectsRequest(bucketName);
        if (filePath != null && (!filePath.trim().equals(""))) {
            request.setPrefix(filePath);
        }
        ObjectListing result = getObsClient().listObjects(request);
        return new Integer(result.getObjects().size());
    }

    /**
     * 获取指定路径下的ObsObject
     *
     * @param bucketName 操作的桶的名称 例："wangmarket1232311"
     * @param filePath   需要检索的文件夹路径
     * @return 路径下的所有的ObsObject，包括子文件夹下的ObsObject
     */
    public List<ObsObject> getFolderObjects(String bucketName, String filePath) {
        List<ObsObject> list = new ArrayList<ObsObject>();
        ListObjectsRequest request = new ListObjectsRequest(bucketName);
        if (filePath != null && (!filePath.trim().equals(""))) {
            request.setPrefix(filePath);
        }
        request.setMaxKeys(100);
        ObjectListing result;
        do {
            result = getObsClient().listObjects(request);
            for (ObsObject obsObject : result.getObjects()) {
                list.add(obsObject);
            }
            request.setMarker(result.getNextMarker());
        } while (result.isTruncated());
        return list;
    }

    /**
     * 删除对象
     *
     * @param bucketName 操作的桶的名称 例："wangmarket1232311"
     * @param fileName   需要删除的对象全名 例："site/20190817/localFile.sh"
     * @return
     */
    public DeleteObjectResult deleteObject(String bucketName, String fileName) {
        return getObsClient().deleteObject(bucketName, fileName);
    }

    /**
     * 创建文件夹
     *
     * @param bucketName 操作的桶的名称 例："wangmarket1232311"
     * @param fileName   新建文件夹的路径，总根路径开始，请务必以"/"结尾。例："2019/0817/"
     * @return
     */
    public PutObjectResult mkdirFolder(String bucketName, String fileName) {
        return getObsClient().putObject(bucketName, fileName, new ByteArrayInputStream(new byte[0]));
    }

    /**
     * 通过流上传字符串为文件
     *
     * @param bucketName 操作的桶的名称 例："wangmarket1232311"
     * @param fileName   上传的路径和文件名 例："site/2010/example.txt"
     * @param content    上传的String字符
     * @param encode     进行转换byte时使用的编码格式 例："UTF-8"
     * @return
     * @throws ObsException
     * @throws UnsupportedEncodingException
     */
    public PutObjectResult putStringFile(String bucketName, String fileName, String content, String encode) throws ObsException, UnsupportedEncodingException {
        return getObsClient().putObject(bucketName, fileName, new ByteArrayInputStream(content.getBytes(encode)));
    }

    /**
     * 上传文件本地文件
     *
     * @param bucketName 操作的桶的名称 例："wangmarket1232311"
     * @param fileName   上传的路径和文件名 例："site/2010/example.txt"
     * @param localFile  需要上传的文件
     * @return
     */
    public PutObjectResult putLocalFile(String bucketName, String fileName, File localFile) {
        if(StringUtils.isEmpty(bucketName)){
            bucketName = this.obsBucketName;
        }
        return getObsClient().putObject(bucketName, fileName, localFile);
    }


    /**
     * 上传文件流
     *
     * @param bucketName  操作的桶的名称 例："wangmarket1232311"
     * @param fileName    上传的路径和文件名 例："site/2010/example.txt"
     * @param inputStream 上传文件的输入流
     * @return
     */
    public PutObjectResult putFileByStream(String bucketName, String fileName, InputStream inputStream) {
        return getObsClient().putObject(bucketName, fileName, inputStream);
    }


    /**
     * 通过流上传文件并设置指定文件属性
     *
     * @param bucketName  操作的桶的名称 例："wangmarket1232311"
     * @param fileName    上传的路径和文件名 例："site/2010/example.txt"
     * @param inputStream 上传文件的输入流
     * @param metaData    上传文件的属性
     * @return
     */
    public PutObjectResult putFilebyInstreamAndMeta(String bucketName, String fileName, InputStream inputStream, ObjectMetadata metaData) {
        return getObsClient().putObject(bucketName, fileName, inputStream, metaData);
    }

    /**
     * 获取当前的桶列表
     *
     * @return 当前桶的列表信息
     */
    public List<S3Bucket> getBuckets() {
        return getObsClient().listBuckets();
    }


    /**
     * 关闭当前的使用的OBSClient
     */
    public void closeOBSClient() {
        if (getObsClient() != null) {
            try {
                getObsClient().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * 为对象设置公共读
     *
     * @param objectKey
     */
    public HeaderResponse setObjectAclPubilcRead(String objectKey) {

        return obsClient.setObjectAcl(obsBucketName, objectKey, AccessControlList.REST_CANNED_PUBLIC_READ);

    }

    /**
     * 获得下载路径
     *
     * @param objectKey
     * @return
     */
    public String signatureUrl(String objectKey) {
        long expireSeconds = 3600L;
        Map<String, String> headers = new HashMap<String, String>();

        String contentType = "text/plain";
        headers.put("Content-Type", contentType);

        TemporarySignatureRequest request = new TemporarySignatureRequest(HttpMethodEnum.PUT, expireSeconds);
        request.setBucketName(obsBucketName);
        request.setObjectKey(objectKey);
        request.setHeaders(headers);

        TemporarySignatureResponse response = obsClient.createTemporarySignature(request);

        return response.getSignedUrl();
    }


}
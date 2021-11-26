package com.xiayu.http;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author xuhongyu
 * @create 2021-11-25 11:27 上午
 */
public class OssPullFileTest {
    public static void main(String[] args) throws IOException {

        String fileUrl = "http://fastdfs.driverglobe.com/group1/M00/10/A0/Ch7o6lpF7vSAWlnNAACeAHa8R8Q491.doc";
        String[] split = fileUrl.split("/.");
        String fileName = split[split.length-1];
        System.out.println(fileName);
        downloadNetFile("http://fastdfs.driverglobe.com/group1/M00/10/A0/Ch7o6lpF7vSAWlnNAACeAHa8R8Q491.doc","/Users/临时文件",fileName);
    }

    /**
     * 下载网络文件
     */
    public static void downloadNetFile(String url, String saveDir, String fileName) {
        try (InputStream ins = new URL(url).openStream()) {
            Path target = Paths.get(saveDir, fileName);
            Files.createDirectories(target.getParent());
            Files.copy(ins, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            // TODO抛异常
        }
    }

}

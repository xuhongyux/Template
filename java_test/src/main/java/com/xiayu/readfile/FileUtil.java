package com.xiayu.readfile;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Description:
 * 工具类  文件操作
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2019/12/30 17:54
 */
public class FileUtil {

    static Logger log = LoggerFactory.getLogger(FileUtil.class);


    /**
     * 功 能: 移动文件(只能移动文件) 参 数: strSourceFileName:指定的文件全路径名 strDestDir: 移动到指定的文件夹 返回值: 如果成功true;否则false
     *
     * @param strSourceFileName
     * @param strDestDir
     * @return testParameter copyTo("C:/Users/xiayu/Desktop/测试文件夹/测试文件.txt", "C:/Users/xiayu/Desktop");
     */

    public static boolean copyTo(String strSourceFileName, String strDestDir) {
        File fileSource = new File(strSourceFileName);
        File fileDest = new File(strDestDir);

        // 如果源文件不存或源文件是文件夹
        boolean exists = fileSource.exists();
        boolean file = fileSource.isFile();
        if (!fileSource.exists() || !fileSource.isFile()) {
            // logger.debug("源文件[" + strSourceFileName + "],不存在或是文件夹!");
            return false;
        }

        // 如果目标文件夹不存在
        if (!fileDest.isDirectory() || !fileDest.exists()) {
            if (!fileDest.mkdirs()) {
                //  logger.debug("目录文件夹不存，在创建目标文件夹时失败!");
                return false;
            }
        }

        try {
            String strAbsFilename = strDestDir + File.separator + fileSource.getName();
            FileInputStream fileInput = new FileInputStream(strSourceFileName);
            FileOutputStream fileOutput = new FileOutputStream(strAbsFilename);

            // logger.debug("开始拷贝文件");
            int count = -1;
            long nWriteSize = 0;
            long nFileSize = fileSource.length();

            byte[] data = new byte[1024];

            while (-1 != (count = fileInput.read(data, 0, 1024))) {
                fileOutput.write(data, 0, count);
                nWriteSize += count;

                long size = (nWriteSize * 100) / nFileSize;
                long t = nWriteSize;
                String msg = null;
                if (size <= 100 && size >= 0) {
                    msg = "\r拷贝文件进度:   " + size + "%   \t" + "\t   已拷贝:   " + t;
                    // logger.debug(msg);
                } else if (size > 100) {
                    msg = "\r拷贝文件进度:   " + 100 + "%   \t" + "\t   已拷贝:   " + t;
                    //  logger.debug(msg);
                }
            }
            fileInput.close();
            fileOutput.close();
            // logger.debug("拷贝文件成功!");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功 能: 移动文件(只能移动文件) 参 数: strSourceFileName: 是指定的文件全路径名 strDestDir: 移动到指定的文件夹中 返回值: 如果成功true; 否则false
     *
     * @param strSourceFileName
     * @param strDestDir
     * @return testFarameter  moveFile("C:/Users/xiayu/Desktop/测试文件夹/测试文件.txt", "C:/Users/xiayu/Desktop");
     */
    public static boolean moveFile(String strSourceFileName, String strDestDir) {
        if (copyTo(strSourceFileName, strDestDir)) {
            delete(strSourceFileName);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 功 能: 删除指定的文件 参 数: 指定绝对路径的文件名 strFileName 返回值: 如果删除成功true否则false;
     *
     * @param path
     * @return testFarameter b = delete("C:/Users/xiayu/Desktop/测试文件夹/测试文件.txt");
     */
    public static void delete(String path) {
        try {
            File file = new File(path);
            if (file.delete()) {
                //System.out.println(file.getName() + " 文件已被删除！");
            } else {
                //  System.out.println("文件删除失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean delete(File file) {
        if (file == null) {
            return true;
        }
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                delete(f);
            }
            return file.delete();
        }
    }


    /**
     * 功 能: 删除文件夹 参 数: strDir 要删除的文件夹名称 返回值: 如果成功true;否则false
     *
     * @param strDir
     * @return
     */
    public static boolean removeDir(String strDir) {
        File rmDir = new File(strDir);
        if (rmDir.isDirectory() && rmDir.exists()) {
            String[] fileList = rmDir.list();

            for (int i = 0; i < fileList.length; i++) {
                String subFile = strDir + File.separator + fileList[i];
                File tmp = new File(subFile);
                if (tmp.isFile()) {
                    tmp.delete();
                } else if (tmp.isDirectory()) {
                    removeDir(subFile);
                }
            }
            rmDir.delete();
        } else {
            return false;
        }
        return true;
    }


    /**
     * 功 能: 创建文件夹 参 数: strDir 要创建的文件夹名称 返回值: 如果成功true;否则false
     *
     * @param strDir
     * @return
     */
    public static boolean makeDir(String strDir) {
        File fileNew = new File(strDir);
        if (!fileNew.exists()) {
            return fileNew.mkdirs();
        } else {
            return true;
        }
    }

    /**
     * 获取文件扩展名
     */
    public static String getFileExtName(String file) {
        if (StringUtils.isEmpty(file)) {
            return ".";
        }
        file = file.replace(File.separator, "/");
        String[] fs = file.split("/");
        if ((fs != null) && (fs.length > 0)) {
            file = fs[(fs.length - 1)];
        }
        int pos = file.lastIndexOf(".");
        if (pos >= 0) {
            return file.substring(pos);
        }
        return ".";
    }


    /**
     * 写入文件
     * 此工具类适合写小文件
     */
    public static void writeToFile(File file, String data) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
            log.info("success write file,the file is " + file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String file, String data) throws IOException {
        File f = new File(file);
        mkdirs(file);
        if (!f.exists()) {
            mkdirs(file);
            f.createNewFile();
        }
        RandomAccessFile fil = null;
        try {
            fil = new RandomAccessFile(f, "rw");
            long fileLength = fil.length();
            fil.seek(fileLength);
            fil.write(data.getBytes("UTF-8"));
        } finally {
            if (fil != null) {
                fil.close();
            }
        }
    }


    /**
     * 创建文件
     */
    public static String mkdirs(String file) {
        File f = new File(file);
        if (!f.exists()) {
            f.mkdirs();
        }
        return file;
    }


    /**
     * 创建文件 注意若存在先创建后删除
     * fileName    文件名称
     *
     * @param path
     * @param fileName
     * @return
     */
    public static File createFile(String path, String fileName) {
        File file = new File(path);
        if (!file.exists()) {
            //创建目录
            file.mkdirs();
        }
        File fileLast = new File(path, fileName);
        try {
            if (fileLast.exists()) {
                // 若存在，先删除后创建
                delete(fileLast);
            }
            fileLast.createNewFile();
            log.info("success create file,the file is " + fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileLast;
    }

    /**
     * 创建文件 注意若存在先创建后删除
     * fileName    文件名称
     *
     * @param path
     * @param fileName
     * @return
     */
    public static File createNewFile(String path, String fileName) {
        File file = new File(path);
        if (!file.exists()) {
            //创建目录
            file.mkdirs();
        }
        File fileLast = new File(path, fileName);
        try {
            fileLast.createNewFile();
            log.info("success create file,the file is " + fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileLast;
    }


    private static ArrayList<Object> scanFiles = new ArrayList<>();

    /**
     * 递归扫描文件夹下面的文件
     *
     * @param folderPath
     * @return
     * @throws RuntimeException
     */
    public static ArrayList<Object> scanFilesWithRecursion(String folderPath) throws RuntimeException {


        ArrayList<String> directories = new ArrayList<>();
        File directory = new File(folderPath);
        if (!directory.isDirectory()) {
            throw new RuntimeException('"' + folderPath + '"' + " input path is not a Directory , please input the right path of the Directory. ^_^...^_^");
        }
        if (directory.isDirectory()) {
            File[] fileList = directory.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                /**如果当前是文件夹，进入递归扫描文件夹**/
                if (fileList[i].isDirectory()) {
                    directories.add(fileList[i].getAbsolutePath());
                    /**递归扫描下面的文件夹**/
                    scanFilesWithRecursion(fileList[i].getAbsolutePath());
                }
                /**非文件夹**/
                else {
                    scanFiles.add(fileList[i].getAbsolutePath());
                }
            }
        }
        return scanFiles;
    }


    /**
     * 读取文件
     *
     * @param file
     * @return
     */
    public static String readFile(File file) {
        BufferedReader reader = null;
        String laststr = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }
}

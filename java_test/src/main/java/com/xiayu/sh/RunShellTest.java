package com.xiayu.sh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author xuhongyu
 * @create 2021-06-18 19:40
 */
public class RunShellTest {
    public static void main(String[] args) throws Exception {
        runShell("/home/xuhongyu/flinkx/flinkx/bin/xiayuTest.sh");
    }

    /**
     * 执行shell
     * @param shpath
     * @return
     * @throws Exception
     */
    public static String runShell(String shpath) throws Exception {

        if (shpath == null || shpath.equals("")) {
            return "shpath is empty";
        }
        Process process;
        try {
            // 使用Runtime来执行command，生成Process对象
            Runtime runtime = Runtime.getRuntime();
            process = runtime.exec(shpath);
            // 取得命令结果的输出流
            InputStream is = process.getInputStream();
            // 用一个读输出流类去读
            InputStreamReader isr = new InputStreamReader(is);
            // 用缓冲器读行
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            //执行关闭操作
            is.close();
            isr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

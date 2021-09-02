package com.xiayu.feign.consumer.shell;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 * @author xuhongyu
 * @create 2021-06-11 17:40
 */
public class Test {
    //创建shell

    public static void createShell(String path, String... strs) throws Exception {
        if (strs == null) {
            System.out.println("strs is null");

            return;

        }

        File sh = new File(path);

        if (sh.exists()) {
            sh.delete();

        }

        sh.createNewFile();

        sh.setExecutable(true);

        FileWriter fw = new FileWriter(sh);

        BufferedWriter bf = new BufferedWriter(fw);

        for (int i = 0; i < strs.length; i++) {
            bf.write(strs[i]);

            if (i < strs.length - 1) {
                bf.newLine();

            }

        }

        bf.flush();

        bf.close();

    }

//执行shell

    public static String runShell(String shpath) throws Exception {
        if (shpath == null || shpath.equals("")) {
            return "shpath is empty";

        }

        Process ps = Runtime.getRuntime().exec(shpath);

        ps.waitFor();

        BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));

        StringBuffer sb = new StringBuffer();

        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");

        }

        String result = sb.toString();

        return result;

    }

//测试效果

    public static void main(String[] args) {
//文件存放路径

        String path = "/home/xxx/java.sh";

//执行的脚本，一个字符串就是一行。

        String[] strs = { "cp aaa.sh aaa2.sh" };

        try {
            Test.createShell(path, strs);

            String result = Test.runShell(path);

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}

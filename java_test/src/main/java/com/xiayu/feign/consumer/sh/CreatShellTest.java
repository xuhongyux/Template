package com.xiayu.feign.consumer.sh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author xuhongyu
 * @create 2021-06-18 15:34
 */
public class CreatShellTest {

    /**
     * 创建shell
     * @param path
     * @param strs
     * @throws Exception
     */
    public static void createShell(String path, String... strs) throws Exception {
        if (strs == null) {
            System.out.println("strs is null");
            return;
        }

        File sh = new File(path);
        if (sh.exists()) {
            sh.delete();
        }
        //判断目标文件所在的目录是否存在
        if(!sh.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            System.out.println("目标文件所在目录不存在，准备创建它！");
            if(!sh.getParentFile().mkdirs()) {
                System.out.println("创建目标文件所在目录失败！");
                return ;
            }
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

    /**
     * 删除文件
     */
    public static void delete(String path){
        try{
            File file = new File(path);
            if(file.delete()){
                System.out.println(file.getName() + " 文件已被删除！");
            }else{
                System.out.println("文件删除失败！");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //测试效果
    public static void main(String[] args) {
        System.out.println("开始调用");
        //生产shell文件存放路径
        String path = "/home/xuhongyu/flinkx/flinkx/bin/xiayuTest.sh";

        StringBuilder runClassCommand = new StringBuilder();
        // 是否挂起
        runClassCommand.append("nohup ");
        // 命令
        runClassCommand.append("$JAVA_RUN -cp $JAR_DIR $CLASS_NAME ");

        // 运行参数
        runClassCommand.append("-mode local \\");
        runClassCommand.append("-job /home/xuhongyu/flinkx/mysqlToMySql.json \\");
        runClassCommand.append("-pluginRoot /home/xuhongyu/flinkx/flinkx/syncplugins\n ");

/*        // 日志名称和地址
        runClassCommand.append(">./log/test.log ");
        runClassCommand.append("2>&1 & ");*/
        //执行的脚本，一个字符串就是一行。
        String[] strs = {
                "#!/usr/bin/env bash",
                "set -e",
                "export FLINKX_HOME=\"$(cd \"`dirname \"$0\"`\"/..; pwd)\"",
                "if [ -n \"${JAVA_HOME}\" ]; then",
                "JAVA_RUN=\"${JAVA_HOME}/bin/java\"",
                "else",
                " if [ `command -v java` ]; then"," JAVA_RUN=\"java\"",
                "else","echo \"JAVA_HOME is not set\" >&2",
                "exit 1",
                "fi",
                "fi",
                "JAR_DIR=$FLINKX_HOME/lib/*",
                "CLASS_NAME=com.dtstack.flinkx.launcher.Launcher","echo \"flinkx starting ...\"",
                runClassCommand.toString()};
        try {
            System.out.println("开始创建shell文件");
            CreatShellTest.createShell(path, strs);
            System.out.println("开始执行");
            String result = CreatShellTest.runShell(path);
            System.out.println("执行完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("删除shell文件");
        delete(path);
    }

}

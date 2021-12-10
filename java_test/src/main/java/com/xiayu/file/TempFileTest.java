package com.xiayu.file;

import java.io.File;
import java.io.IOException;

/**
 * @author xuhongyu
 * @create 2021-12-09 10:25 上午
 */
public class TempFileTest {

    public static void main(String[] args) throws IOException {
        String tempPath = System.getProperty("java.io.tmpdir") + File.separator;
        // /var/folders/fx/gt3q0lt92d1f5rbzb___cq8r0000gn/T//
        System.out.println(tempPath);

        File temp = File.createTempFile("temp-file-name", ".tmp");
        String path = temp.getPath();
        // /var/folders/fx/gt3q0lt92d1f5rbzb___cq8r0000gn/T/temp-file-name1850625634769826533.tmp
        System.out.println(path);
    }
}

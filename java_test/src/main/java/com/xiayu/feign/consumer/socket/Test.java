package com.xiayu.feign.consumer.socket;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Description:
 *
 * @version v1.0.0
 * @Author xiayu
 * @Date 2021/1/16 14:27
 */
public class Test {

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            String host = args[0];
            InetAddress[] allByName = InetAddress.getAllByName(host);
            for (InetAddress inetAddress : allByName) {
                System.out.println(inetAddress);
            }
        } else {
            InetAddress localHostAddress = InetAddress.getLocalHost();
            System.out.println(localHostAddress);
        }
    }
}

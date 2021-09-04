package com.xiayu.linked;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-08-28-2:47 下午
 */
public class LinkedList {
    /**
     * 反转链表
     */
    @Test
    public void  reversionList(){
        String str  = "abc";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");

        int length = str.length();
        for (int i = length ; i>0;i--){
            stringBuilder.append(str.charAt(i-1));
        }
        stringBuilder.append("}");
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while(true) {
            str = bf.readLine();
            if(str==null||str.length()==0) {
                break;
            }
            StringBuffer sb=new StringBuffer();
            sb.append("{");
            for(int i = str.length()-2; i>=1; i-- ){
                sb.append(str.charAt(i));
            }
            sb.append("}");
            System.out.println(sb.toString());
        }
    }
}
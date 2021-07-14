package com.xiayu.bytetest;

import java.io.UnsupportedEncodingException;

/**
 * @author xuhongyu
 * @create 2021-07-03 16:05
 */
public class Test {


    public static void main(String[] args) throws UnsupportedEncodingException {
        String srcStr1 = "我ABC";
        String srcStr2 = "我ABC汉的DEF";

        splitString(srcStr1, 4);
        splitString(srcStr2, 6);

    }

    public static void splitString(String str,int size) throws UnsupportedEncodingException, UnsupportedEncodingException {
        //判断是否为空
        if(str==null){
            System.out.println("splitString is null");
            return;
        }
        //判断分割位置是否小于等于0
        if(size<=0){
            System.out.println("截取字节长度必须大于0");
            return;
        }

        //默认UTF-8 中文一般三个字节表示，gbk两个字节，UTF-8变化就是%3，gbk变化就是%3
        byte[] bytes = str.getBytes("utf-8");
        //如果截取长度大于bytes长度，则直接打印字符串
        if(size >= bytes.length){
            System.out.println("splitString="+str);
            return ;
        }
        //如果是中文，bytes为负数。最后一个不是中文，则直接分割
        if(bytes[size-1] > 0){
            String splitString = new String(bytes,0,size,"utf-8");
            System.out.println("splitString="+splitString);
            return;
        }
        //字节负数统计并进行求模​
        int num = 0;
        //循环到需要分割的长度，后面的不需要
        for(int i = 0 ; i < size; i++ ){
            if(bytes[i]<0){
                num++;
                num = num % 3;
            }
        }
        String splitString = new String(bytes,0,size-num,"utf-8");
        System.out.println("splitString="+splitString);
    }





}

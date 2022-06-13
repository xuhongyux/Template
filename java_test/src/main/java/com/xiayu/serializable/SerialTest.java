//package com.xiayu.serializable;
//
//import org.junit.Test;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//
///**
// * @author xuhongyu
// * @describe
// * @create 2021-09-01-10:17 上午
// */
//public class SerialTest {
//
//    public static void main(String[] args) {
//
//    }
//    @Test
//    public void serial(){
//        Person xiayu = new Person(1L, "xiayu");
//
//        System.out.println(xiayu);
//        try {
//
//            FileOutputStream fos = new FileOutputStream("/Users/xiayu/临时文件/person.txt");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(xiayu);
//            oos.flush();
//            oos.close();
//
//        } catch (Exception e){
//
//        }
//    }
//    @Test
//    public  void backSerial(){
//        Person p;
//        try {
//            FileInputStream fis = new FileInputStream("/Users/xiayu/临时文件/person.txt");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            p = (Person) ois.readObject();
//            ois.close();
//            System.out.println(p.toString());
//            System.out.println(p.name);
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
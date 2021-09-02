package com.xiayu.feign.consumer.stream;

import com.xiayu.feign.consumer.admin.UserPo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xuhongyu
 * @describe     stream学习
 * @create 2021-03-17-9:57 上午
 */
public class LearnTest {
    public static void main(String[] args) {
        list(1000);
    }

    public static void list(int x){
        List<Integer> integers = new ArrayList<>(1000);
        for (int i = 0 ;i<x;i++){
            integers.add((int) (Math.random()*1000)+1);
        }
        Stream<Integer> stream = integers.stream().sorted().limit((long) (x * 0.9));
        //最大值
        Optional<Integer> max = integers.stream().sorted().limit((long) (x * 0.9)).max((po1, po2) -> {
            return po1.compareTo(po2);
        });
        //最小值
        Optional<Integer> min = integers.stream().sorted().limit((long) (x * 0.9)).min((po1, po2) -> {
            return po1.compareTo(po2);
        });
        List<Integer> collect = stream.collect(Collectors.toList());
        List<List<Integer>> lists = averageAssign(collect);

        int size = 0;
        for (List<Integer> list : lists) {
            System.out.println(("区间值")+ list.toString());
            size=  list.size()+size;
        }
        System.out.println("数值个数："+size);
        System.out.println("最大值:"+max.get());
        System.out.println("最小值:"+min.get());
    }
    /**
     * 分区
     */
    public static  List<List<Integer>> averageAssign(List<Integer> source) {
        int n = 9;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int remainder = source.size() % n;
        int number = source.size() / n;
        int offset = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> value = null;
            if (remainder > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remainder--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }
        return result;
    }

    public static void tree(int n){
        int [][] a =  new int[n][n];
        for(int i = 0; i<= n; i++){

            for(int j = 0; j <= 1+2*i ;j++){
                if (j == 0){
                    a [i][j] = i+1;
                    break;
                }

                if(j == 1+2*i) {
                    a[i][j] = i + 1;
                    break;
                }
                a[i][j]= a[i-1][j-1]+a[i-1][j];
                }
            }
           // System.out.println(a[i][0]);
        }




    @Test
    public void testSorted(){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(3);

        List<Integer> collect = list.stream().filter(po -> po != 1).sorted().collect(Collectors.toList());
        System.out.println(collect);


    }
    @Test
    public void testFilter(){
        List<UserPo> listUserPo = UserPo.getListUserPo();
        List<UserPo> collect = listUserPo.stream().distinct().filter(userPo -> userPo.getName().equals("xiayu")).collect(Collectors.toList());
    }

    @Test
    public void testDistinct(){
        List<UserPo> listUserPo = UserPo.getListUserPo();
        List<UserPo> collect = listUserPo.stream().distinct().collect(Collectors.toList());
    }

    @Test
    public void  testMap(){
        List<UserPo> listUserPo = UserPo.getListUserPo();

        List<String> collect = listUserPo.stream().map(UserPo::getName).distinct().collect(Collectors.toList());
        Stream<String> stringStream = listUserPo.stream().map(UserPo::getName);



        System.out.println(collect);


        // list.stream().filter(vo ->vo.containsKey("xiayu")).collect(Collectors.toCollection(map ->map));




    }


}
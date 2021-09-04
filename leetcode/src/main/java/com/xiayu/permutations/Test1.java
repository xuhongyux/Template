package com.xiayu.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuhongyu
 * @create 2021-06-10 10:09
 */
public class Test1 {
    public  static void p(List<String> arrays, int begin, int number, List<String> list,List<Object> results){

        if(number==0){
            List<String> objects = new ArrayList<>();
             objects.addAll(list);
            results.add(objects);
            return;
        }
        if(begin==arrays.size()){
            return;
        }
        list.add(arrays.get(begin));
        p(arrays, begin+1, number-1,list,results);
        list.remove(arrays.get(begin));
        p(arrays, begin+1, number,list,results);
    }
    public static void main(String[] args) {
        List<String> list_1 = new ArrayList<>();
        list_1.add("张");
        list_1.add("李");
        list_1.add("赵");
        list_1.add("徐");

        char[] arrays={'a','b','c'};
        List<String> listResult= new ArrayList();
        List<Object> results= new ArrayList();
        for(int number=1;number<=list_1.size();number++){
            p(list_1,0,number,listResult,results);
        }
        System.out.println(results.toString());
    }

}

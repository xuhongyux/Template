package com.xiayu.feign.consumer.permutations;

import com.beust.jcommander.internal.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 多列的排列组合
 * @author xuhongyu
 * @create 2021-03-30 14:55
 */
public class MultipleColumns {
    public final  static String FLAG = "null";

    /**
     * 获取两个属性的排列组合
     *
     * @param dimensionType1
     * @param dimensionType2
     * @param number         第几次组合
     * @return
     */
    private static List getDimensionPermutation(List<String> dimensionType1, List<String> dimensionType2, Integer number) {
        if (number == 0) {
            return dimensionType2;
        }
        List results = new ArrayList(dimensionType1.size() * dimensionType2.size() + dimensionType2.size() + dimensionType1.size());
        for (String type1 : dimensionType1) {
            for (String type2 : dimensionType2) {
                results.add(type1 + FLAG + type2);
            }
        }
        return results;
    }

//    public static void main(String[] args) throws InterruptedException {
//        Date date = new Date();
//        List<List<String>> sortDimensionList = Lists.newArrayList();
//
//        List<String> objects1 = Lists.newArrayList();
//        List<String> objects2 = Lists.newArrayList();
//        List<String> objects3 = Lists.newArrayList();
//
//        for(int i = 0 ;i<1000000;i++){
//            Thread.sleep(1000);
//            objects1.add("1属性值-"+i);
//            objects2.add("2属性值-"+i);
//            objects3.add("3属性值-"+i);
//        }
//        sortDimensionList.add(objects1);
//        sortDimensionList.add(objects2);
//        sortDimensionList.add(objects3);
//
//        List<String> dimensionPermutation = Lists.newArrayList();
//        for (int i = 0; i < sortDimensionList.size(); i++) {
//            dimensionPermutation = getDimensionPermutation(dimensionPermutation, sortDimensionList.get(i), i);
//        }
//        System.out.println(dimensionPermutation);
//        System.out.println("时间"+ MapperUtil.getInterval(date,new Date()));
//    }

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<List<String>>();

        List<String> objects1 = Lists.newArrayList();
        List<String> objects2 = Lists.newArrayList();
        List<String> objects3 = Lists.newArrayList();

        for(int i = 0 ;i<100000000;i++){
            objects1.add("1属性值-"+i);
            objects2.add("2属性值-"+i);
            objects3.add("3属性值-"+i);
        }



    }




        public  static void descartes(List<List<String>> dimvalue, List<List<String>> result, int layer, List<String> curList) {
            if (layer < dimvalue.size() - 1) {
                if (dimvalue.get(layer).size() == 0) {
                    descartes(dimvalue, result, layer + 1, curList);
                } else {
                    for (int i = 0; i < dimvalue.get(layer).size(); i++) {
                        List<String> list = new ArrayList<String>(curList);
                        list.add(dimvalue.get(layer).get(i));
                        descartes(dimvalue, result, layer + 1, list);
                    }
                }
            } else if (layer == dimvalue.size() - 1) {
                if (dimvalue.get(layer).size() == 0) {
                    result.add(curList);
                } else {
                    for (int i = 0; i < dimvalue.get(layer).size(); i++) {
                        List<String> list = new ArrayList<String>(curList);
                        list.add(dimvalue.get(layer).get(i));
                        result.add(list);
                    }
                }
            }
        }



}

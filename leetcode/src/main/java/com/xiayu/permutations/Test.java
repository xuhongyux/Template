package com.xiayu.permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 排列组合问题
 *
 * @author xuhongyu
 * @create 2021-03-27 15:21
 */
public class Test {

    private static final String FLAG = "@";
    private static final String NULL = "null";

    //    public static void main(String[] args) {
//        List<String[]> list = new ArrayList<>();
//        list.add(new String[]{"A", "B", "C"});
//        list.add(new String[]{"D", "E", "F"});
//        list.add(new String[]{"X", "Y", "Z"});
//
//        for (int i = 0; i < list.size() - 1; i++) {
//           // list.set(i + 1, combo(list.get(i), list.get(i + 1)));
//        }
//        String[] resultList = list.get(list.size() - 1);
//        for (int i = 0; i < resultList.length; i++) {
//            if (i % 10 == 0 && i != 0){
//                System.out.println();
//            }
//            System.out.print(resultList[i] +"\t");
//        }
//    }
    public static void main(String[] args) {

        List<String> list_1 = new ArrayList<>();
        list_1.add("张");
        list_1.add("李");
        List<String> list_2 = new ArrayList<>();
        list_2.add("飞");
        list_2.add("杰");
        list_2.add("谦");
        List<String> combo1 = getDimensionPermutation(list_1, list_2, 1);
        List<String> combo1pro = getDimensionPermutationPro(list_1, list_2, 1);

        Set<String> objects = new HashSet<>(combo1);
        Set<String> objectsPro = new HashSet<>(combo1pro);

        List<String> list_3 = new ArrayList<>();
        list_3.add("雨");
        list_3.add("龙");
        List<String> combo2 = getDimensionPermutation(combo1, list_3, 2);
        Set<String> objects2 = new HashSet<>(combo2);
        System.out.println(combo2.toString());
    }

    public static List getDimensionPermutationPro(List<String> dimensionType1, List<String> dimensionType2, Integer number) {
        if(number == 0){
            return dimensionType2;
        }

        List results = new ArrayList(dimensionType1.size() * dimensionType2.size() + dimensionType2.size() + dimensionType1.size());
        for (String type1 : dimensionType1) {
            for (String type2 : dimensionType2) {
                results.add(type1 + FLAG + type2);
            }
        }
        for (String type : dimensionType1) {
            results.add(type + FLAG + NULL);
        }
        for (String type : dimensionType2) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < number; i++) {
                str.append(NULL + FLAG);
            }
            results.add(str.toString() + type);
        }
        return results;
    }

    /**
     * 获取两个属性的排列组合
     * @param dimensionType1
     * @param dimensionType2
     * @param number 第几次组合
     * @return
     */
    public static List getDimensionPermutation (List<String> dimensionType1, List<String> dimensionType2, Integer number) {

        List results = new ArrayList(dimensionType1.size() * dimensionType2.size() + dimensionType2.size() + dimensionType1.size());
        for (String type1 : dimensionType1) {
            for (String type2 : dimensionType2) {
                results.add(type1 + FLAG + type2);
            }
        }
        for (String type : dimensionType1) {
            results.add(type + FLAG + NULL);
        }
        for (String type : dimensionType2) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < number; i++) {
                str.append(NULL + FLAG);
            }
            results.add(str.toString()+type);
        }
        return results;
    }

//    public static void main(String[] args) {
//        List<String> results = new ArrayList<>();
//
//        List<String> list_1 = new ArrayList<>();
//        list_1.add("1_王");
//        list_1.add("1_赵");
//        list_1.add("1_张");
//        list_1.add("1_李");
//        list_1.add("1_孙");
//        List<String> list_2 = new ArrayList<>();
//
//        list_2.add("2_志");
//        list_2.add("2_月");
//        list_2.add("2_金");
//        list_2.add("2_中");
//        list_2.add("2_离");
//
//        List<String> list_3 = new ArrayList<>();
//
//        list_3.add("3_雨");
//        list_3.add("3_龙");
//        list_3.add("3_胜");
//        list_3.add("3_杰");
//        list_3.add("3_浩");
//
//
//        for (String list1 : list_1) {
//            for (String list2 : list_2) {
//                for (String list3 : list_3) {
//                    results.add(list1+FLAG+list2+FLAG+list3);
//                }
//            }
//        }
//        System.out.println(results.toString());
//
//
//
//    }

}

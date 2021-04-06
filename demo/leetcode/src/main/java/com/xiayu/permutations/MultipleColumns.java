package com.xiayu.permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 多列的排列组合
 * @author xuhongyu
 * @create 2021-03-30 14:55
 */
public class MultipleColumns {

    public static void main(String[] args) {
        List datas = new ArrayList();

        datas.add("1");

        datas.add("2");

        datas.add("3");

        datas.add("4");

        datas.add("5");

        datas.add("6");

        List result = new ArrayList();

        generatePerCom(datas, result, new StringBuilder());

        System.out.println(Arrays.toString(result.toArray()));

    }

    private static void generatePerCom(List datas,List result,StringBuilder builder) {
        if (datas.isEmpty()) {
            result.add(builder.toString());

            return;

        }

        int size = datas.size();

        List temp;

        StringBuilder tempBuilder;

        for (int i = 0; i < size; i++) {
            tempBuilder = new StringBuilder();

            tempBuilder.append(builder);

            tempBuilder.append(datas.get(i));

            temp = new ArrayList();

            temp.addAll(datas);

            temp.remove(i);

            generatePerCom(temp, result, tempBuilder);

        }

    }


}

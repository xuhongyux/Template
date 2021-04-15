package com.xiayu.test;

import com.google.common.collect.Maps;
import com.xiayu.admin.Root;
import com.xiayu.admin.User;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


/**
 * @author xuhongyu
 * @describe
 * @create 2021-01-12-18:48
 */
public abstract class Test {
    private String a;

    public static void main(String[] args) throws Exception {
        Map<String , String> objectObjectHashMap = Maps.newHashMap();
        String s = objectObjectHashMap.get("123");
        System.out.println(s);

    }



    public void doubleLong(){
        Double a = new Double(1.1848009E7);
        double b = a - 10000000;
        System.out.println(b);
    }

    public void  longTest(){
        long a = Long.MAX_VALUE;
        long b =  60*60*24*360;
        System.out.println(a);
        System.out.println(b);
        System.out.println(a/b);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts.size() < 2) { // 快速返回
            return accounts;
        }

        Map<String, Integer> emailIndexMap = new HashMap<>(); // email -> 最小索引index
        Map<Integer, Set<String>> indexEmailsMap = new HashMap<>(); // 最小索引index -> email集

        for (int i = 0; i < accounts.size(); i++) {
            int minIndex = i; // 该账号email集的最小索引index
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailIndexMap.containsKey(email)) {
                    minIndex = Math.min(minIndex, emailIndexMap.get(email));
                }
            }

            indexEmailsMap.putIfAbsent(minIndex, new TreeSet<>());

            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailIndexMap.containsKey(email)) {
                    int index = emailIndexMap.get(email);
                    if (index != minIndex) { // 将连通的账户集设为最小索引index
                        for (String moveEmail : indexEmailsMap.remove(index)) {
                            emailIndexMap.put(moveEmail, minIndex);

                            indexEmailsMap.get(minIndex).add(moveEmail);
                        }
                    }
                } else {
                    emailIndexMap.put(email, minIndex);

                    indexEmailsMap.get(minIndex).add(email);
                }
            }
        }

        List<List<String>> result = new LinkedList<>();

        indexEmailsMap.forEach((i, emails) -> {

            List<String> entry = new LinkedList<>();
            entry.add(accounts.get(i).get(0));
            entry.addAll(emails);

            result.add(entry);
        });

        return result;
    }

    public static List<List<String>> accountsMerge123(List<List<String>> accounts) {
        //
        Map<String, Integer> emailMap = new HashMap<>();

        // 最小索引index -> email集
        Map<Integer, Set<String>> indexEmailsMap = new HashMap<>();
        //行
        for (int i = 0; i < accounts.size(); i++) {
            // 该账号email集的最小索引index
            int minIndex = i;
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailMap.containsKey(email)) {
                    minIndex = Math.min(minIndex, emailMap.get(email));
                }
            }

            indexEmailsMap.putIfAbsent(minIndex, new TreeSet<>());
            //列
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailMap.containsKey(email)) {
                    int index = emailMap.get(email);
                    if (index != minIndex) {
                        for (String moveEmail : indexEmailsMap.remove(index)) {
                            emailMap.put(moveEmail, minIndex);

                            indexEmailsMap.get(minIndex).add(moveEmail);
                        }
                    }
                } else {
                    emailMap.put(email, minIndex);

                    indexEmailsMap.get(minIndex).add(email);
                }
            }
        }

        List<List<String>> result = new LinkedList<>();
        // 整理结果
        for (int key : indexEmailsMap.keySet()) {
            //  List<String> res = (List<String>) indexEmailsMap.get(key);
            if (indexEmailsMap.get(key).size() == 0) {
                break;
            }
            List<String> res = new ArrayList<>(indexEmailsMap.get(key));
            Collections.sort(res);
            res.add(0, accounts.get(key).get(0));
            result.add(res);
        }

        return result;
    }


}

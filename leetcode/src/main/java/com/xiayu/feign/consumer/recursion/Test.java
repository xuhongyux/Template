package com.xiayu.feign.consumer.recursion;

/**
 * @author xuhongyu
 * @describe
 * @create 2021-08-28-4:02 下午
 */
public class Test {
    public static void main(String[] args) {
        int fibonacci = Fibonacci(10);
        System.out.println(fibonacci);
    }

    public static int Fibonacci(int n) {
        if (n<=1) {
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}
package com.zuo.subject1;

/**
 * 递归
 *
 * @author lkj
 * @date 2021/3/30
 */
public class Recursion4 {
    public static void main(String[] args) {
        System.out.println(f(10));
    }

    private static long f(int n) {
        if (n < 1) {
            return -1;
        }
        if (n == 1) {
            return 1;
        }
        return n + f(n - 1);
    }
}

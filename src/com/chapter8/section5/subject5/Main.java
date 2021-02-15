package com.chapter8.section5.subject5;

/**
 * @author Liu
 * @date 2021/2/12 13:40
 */
public class Main {

    public static void main(String[] args) {
        int[] array = {1, 7, 17, 2, 6, 3, 14};
        findSum(array, 20);
    }

    private static void findSum(int[] a, int sum) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (a[i] + a[j] == sum) {
                    System.out.println(a[i] + "," + a[j]);
                }
            }
        }
    }
}

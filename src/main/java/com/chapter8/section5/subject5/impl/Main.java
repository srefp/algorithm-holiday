package com.chapter8.section5.subject5.impl;

import java.util.Arrays;

/**
 * @author Liu
 * @date 2021/2/12 13:53
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 7, 17, 2, 6, 3, 14};
        findNum(array, 20);
    }

    private static void findNum(int[] a, int sum) {
        Arrays.sort(a);

        int begin = 0;
        int end = a.length - 1;
        while (begin < end) {
            if (a[begin] + a[end] < sum) {
                begin++;
            } else if (a[begin] + a[end] > sum) {
                end--;
            } else {
                System.out.println(a[begin] + "," + a[end]);
                begin++;
                end--;
            }
        }
    }
}

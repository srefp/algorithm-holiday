package com.chapter8.section5.subject6;

/**
 * @author Liu
 * @date 2021/2/12 14:15
 */
public class Main {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8};
        shiftK(array, 2);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static void shiftK(int[] a, int k) {
        int n = a.length;
        k = k % n; // 为了防止k比n大，右移k位跟右移k%n位的结果时一样的
        reverse(a, n - k, n - 1);
        reverse(a, 0, n - k - 1);
        reverse(a, 0, n - 1);
    }

    private static void reverse(int[] a, int b, int e) {
        for (; b < e; b++, e--) {
            int tmp = a[e];
            a[e] = a[b];
            a[b] = tmp;
        }
    }
}

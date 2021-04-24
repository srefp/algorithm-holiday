package com.chapter8.section5.subject8;

/**
 * @author Liu
 * @date 2021/3/26 22:56
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 4, 3, 5, 4, 1};
        int num = findNotDouble(array);
        System.out.println(num);
    }

    private static int findNotDouble(int[] a) {
        int len = a.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            result ^= a[i];
        }
        return result;
    }
}

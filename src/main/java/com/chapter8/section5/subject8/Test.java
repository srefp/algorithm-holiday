package com.chapter8.section5.subject8;

/**
 * 3的倍数
 *
 * @author lkj
 * @date 2021/4/8
 */
public class Test {
    public static int findOnce(int a[], int appearTimes) {
        int n = a.length;
        int[] bitCount = new int[32];
        // 计算数组中所有数组对应的二进制数各个位置上出现1的次数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 32; j++) {
                bitCount[j] += ((a[i] >> j) & 1);
            }
        }
        // 若某位上的结果不能被整除，则肯定目标数字在这一位上
        int appearOne = 0;
        for (int i = 0; i < 32; i++) {
            if (bitCount[i] % appearTimes != 0) {
                appearOne += (1 << i);
            }
        }
        return appearOne;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 1, 2, 4, 2, 4, 4, 1, 3};
        int num = findOnce(array, 3);
        System.out.println(num);
    }
}

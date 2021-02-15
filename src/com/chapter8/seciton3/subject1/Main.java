package com.chapter8.seciton3.subject1;

/**
 * @author Liu
 * @date 2021/2/15 14:20
 */
public class Main {
    public static void main(String[] args) {
        int[] a = {4, 2, 5, 3, 9, 7, 8, 6, 0, 1};
        selectSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void selectSort(int[] a) {
        int i;
        int j;
        int n = a.length;
        int flag;
        int tmp;

        for (i = 0; i < n; i++) {
            flag = i;

            // 从i后面一个开始
            for (j = i + 1; j < n; j++) {
                // 判断谁最小
                if (a[j] < a[flag]) {
                    // flag=谁，谁就是最小的
                    flag = j;
                }
            }

            if (flag != i) {
                // 交换a[flag]和a[i]的值
                tmp = a[flag];
                a[flag] = a[i];
                a[i] = tmp;
            }

        }
    }
}

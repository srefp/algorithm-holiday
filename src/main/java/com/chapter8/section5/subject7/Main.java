package com.chapter8.section5.subject7;

/**
 * @author Liu
 * @date 2021/2/12 19:11
 */

import org.junit.Test;

/**
 * 【问题描述】给定一个无序的数组，从一个数组中找出第k个最小的数，例如，对于给定数组序列{1,5,2,6,8,0,6}，其中第4小的数为5。
 *
 * 方法一：排序法
 *
 * 最容易想到的方法就是对数组进行排序，
 * 排序后的数组中第k-1个位置上的数字即为数组的第k个最小的数
 * （原因时数组下标从0开始计数），这
 * 种方法最好的时间复杂度为O(nlogn)
 *
 * 方法二：剪枝法
 *
 * 采用快速排序的思想来实现。
 * 主要思路如下：选一个数tmp=a[n-1]作为枢纽，
 * 把比它小的数都放在它的左边，比它大的数都放在它的右边，
 * 然后判断tmp的位置，如果它的位置为k-1，那么它就是第k个小的数；
 * 如果它的位置小于k-1，那么说明第k个小的元素一定在数组的右半部分，
 * 再用递归的方法在数组的右半部分继续查找；
 * 否则第k个小的元素在数组的左半部分，
 * 采用递归的方法在左半部分数组中继续查找。示例如下。
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 8, 0, 6};
        int kMin = getKMin(array, 4);
        System.out.println(kMin);
    }

    private static int getKMin(int[] a, int k) {
        if (a == null) {
            return Integer.MIN_VALUE;
        }
        if (a.length < k) {
            return Integer.MIN_VALUE;
        }
        return quickSort(a, 0, a.length - 1, k);
    }

    private static int quickSort(int[] a, int low, int high, int k) {
        int i, j;
        int tmp;
        if (low > high) {
            return Integer.MIN_VALUE;
        }
        i = low;
        j = high;
        tmp = a[i];
        while (i < j) {
            while (i < j && a[j] >= tmp) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] < tmp) {
                i++;
            }
            if (i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = tmp;
        if (i + 1 == k) {
            return tmp;
        } else if (i + 1 > k) {
            return quickSort(a, low, i - 1, k);
        } else {
            return quickSort(a, i + 1, high, k);
        }
    }

}

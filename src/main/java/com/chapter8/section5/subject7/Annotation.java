package com.chapter8.section5.subject7;

/**
 * @author Liu
 * @date 2021/2/12 19:11
 */


/**
 * 【问题描述】给定一个无序的数组，从一个数组中找出第k个最小的数，例如，对于给定数组序列{1,5,2,6,8,0,6}，其中第4小的数为5。
 * <p>
 * 方法一：排序法
 * <p>
 * 最容易想到的方法就是对数组进行排序，
 * 排序后的数组中第k-1个位置上的数字即为数组的第k个最小的数
 * （原因时数组下标从0开始计数），这
 * 种方法最好的时间复杂度为O(nlogn)
 * <p>
 * 方法二：剪枝法
 * <p>
 * 采用快速排序的思想来实现。
 * 主要思路如下：选一个数tmp=a[n-1]作为枢纽，
 * 把比它小的数都放在它的左边，比它大的数都放在它的右边，
 * 然后判断tmp的位置，如果它的位置为k-1，那么它就是第k个小的数；
 * 如果它的位置小于k-1，那么说明第k个小的元素一定在数组的右半部分，
 * 再用递归的方法在数组的右半部分继续查找；
 * 否则第k个小的元素在数组的左半部分，
 * 采用递归的方法在左半部分数组中继续查找。示例如下。
 */
public class Annotation {
    public static void main(String[] args) {
        int[] array = {5, 1, 2, 6, 8, 0, 6};
        int kMin = getKMin(array, 4);
        System.out.println(kMin);
    }

    private static int getKMin(int[] a, int k) {
        // 如果数组为空或者长度小于k，返回最小整数值
        if (a == null) {
            return Integer.MIN_VALUE;
        }
        if (a.length < k) {
            return Integer.MIN_VALUE;
        }
        return quickSort(a, 0, a.length - 1, k);
    }

    /**
     * @param a 数组
     * @param low 数组最小下标
     * @param high 数组最大下标
     * @param k 位置
     * @return
     */
    private static int quickSort(int[] a, int low, int high, int k) {
        int i, j;
        int tmp;
        // 如果数组最小下标大于数组最大下标，即左边跑右边去了，就返回最小整数值
        if (low > high) {
            return Integer.MIN_VALUE;
        }
        // 选取最左边的数作为中间数
        i = low;
        j = high;
        tmp = a[i];

        while (i < j) {
            while (i < j && a[j] >= tmp) {
                // 如果i在j的左边并且右边的数值大于等于tmp，右下标向左移
                j--;
            }
            // while结束后，即在右边找到了一个小于tmp的数
            if (i < j) {
                // 如果i在j左边，将右边的值赋值给左边，然后i向右移
                a[i++] = a[j];
            }
            while (i < j && a[i] < tmp) {
                // 如果i在j的左右并且左边的数值小于tmp，左下标右移
                i++;
            }
            // while结束后，即在左边找到了一个大于等于tmp的数
            if (i < j) {
                // 如果i在j左边，将左边的值赋值给右边，然后j向左移
                a[j--] = a[i];
            }
        }
        // 跳出循环时i == j
        // i即为中间的数，在i的左边都是比i小的，在i的右边都是比i大的
        a[i] = tmp;
        if (i + 1 == k) {
            // 如果中间的这个数刚好是第k小的，返回tmp
            return tmp;
        } else if (i + 1 > k) {
            // 中间的数的位置在k右边，于是找左半部分的
            return quickSort(a, low, i - 1, k);
        } else {
            // 中间的数的位置在k左边，于是找右半部分的
            return quickSort(a, i + 1, high, k);
        }
    }

}

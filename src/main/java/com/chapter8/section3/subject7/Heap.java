package com.chapter8.section3.subject7;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Liu
 * @date 2021/3/27 8:58
 */
public class Heap {
    public static void maxHead(int[] a, int len, int index) {
        // 左孩子
        int left = 2 * index + 1;
        // 右孩子
        int right = 2 * index + 2;
        // 最大数
        int maxIndex = index;

        if (left < len && a[left] < a[maxIndex]) {
            maxIndex = left;
        }
        if (right < len && a[right] < a[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != index) {
            swap(a, index, maxIndex);
            maxHead(a, len, maxIndex);
        }
    }

    private static void swap(int[] a, int index, int maxIndex) {
        List<Integer> list = new ArrayList<>();
    }
}

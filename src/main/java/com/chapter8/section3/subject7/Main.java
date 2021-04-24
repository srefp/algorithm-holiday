package com.chapter8.section3.subject7;

/**
 * 如何进行堆排序
 *
 * @author Liu
 * @date 2021/3/27 8:29
 */
public class Main {

    public static void main(String[] args) {
        int[] a = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
        myMinHeapSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void myMinHeapSort(int[] a) {
        int len = a.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustMinHeap(a, i, len - 1);
        }
        for (int i = len - 1; i >= 0; i--) {
            int tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            adjustMinHeap(a, 0, i - 1);
        }
    }

    private static void adjustMinHeap(int[] a, int pos, int len) {
        int tmp;
        int child;
        for (tmp = a[pos]; 2 * pos + 1 <= len; pos = child) {
            child = 2 * pos + 1;
            if (child < len && a[child] > a[child + 1]) {
                child++;
            }
            if (a[child] < tmp) {
                a[pos] = a[child];
            } else {
                break;
            }
            a[pos] = tmp;
        }
    }
}

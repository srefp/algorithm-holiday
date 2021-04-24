package com.leetcode.subject190;

import org.junit.Test;

public class Solution {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

    public int reverse(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int rev = solution.reverseBits(2);
        System.out.println(rev);
        System.out.println(Integer.toBinaryString(rev));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.reverse(2));
    }

    @Test
    public void test01() {
        // 11111111111111111111111111111000
        System.out.println(Integer.toBinaryString(-8));
        // 11111111111111111111111111111110
        System.out.println(Integer.toBinaryString(-8 >> 2));
        // 1000
        System.out.println(Integer.toBinaryString(8));
        // 10
        System.out.println(Integer.toBinaryString(8 >> 2));

        System.out.println(-8);
        System.out.println(-8 >> 2);
        System.out.println(8);
        System.out.println(8 >> 2);
        // -1
        System.out.println(-1 >> 2);
        // 0
        System.out.println(-1 / 2);
    }

    @Test
    public void test02() {
        System.out.printf("%032d", Integer.valueOf(Integer.toBinaryString(4)));
        System.out.println();
        System.out.printf("%032d", Integer.valueOf(Integer.toBinaryString(2)));
        System.out.println();
        System.out.println(4 & 2);
    }
}
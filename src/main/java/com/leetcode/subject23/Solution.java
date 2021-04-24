package com.leetcode.subject23;

/**
 * 合并k个排序列表
 * @author lkj
 * @date 2021/3/30
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (true) {
            // 最小链表第一个结点值所在的索引
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minIndex == -1 || lists[i].val < lists[minIndex].val) {
                    minIndex = i;
                }
            } // O(k)
            // 所有链表结点已经串起来了
            if (minIndex == -1) {
                break;
            }

            cur = cur.next = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
        } // O(kn)
        return head.next;
    }

}
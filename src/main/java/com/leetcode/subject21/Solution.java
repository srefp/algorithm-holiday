package com.leetcode.subject21;

/**
 * 合并两个有序链表
 *
 * @author lkj
 * @date 2021/3/30
 */
public class Solution {

    /**
     * 只要是用到递归，首先要搞清楚一个问题：这个函数的功能是什么？
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 递归基：边界
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 添加虚拟头节点
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists0(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 头节点
        ListNode head = new ListNode(0);

        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur = cur.next = l1;
                l1 = l1.next;
            } else {
                cur = cur.next = l2;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }

        return head.next;
    }
}

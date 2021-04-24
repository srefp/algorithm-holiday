package com.chapter8.section1.subject2;

import java.util.Hashtable;

/**
 * 如何从链表中删除重复数据？
 *
 * @author Liu
 * @date 2021/3/13 13:52
 */
public class Main {


    private static Node head;

    static {
        head = new Node();
        Node node1 = new Node(1);
        Node node2 = new Node(5);
        Node node3 = new Node(6);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        Node node6 = new Node(1);
        Node node7 = new Node(1);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
    }

    public static void main(String[] args) {
        Node head = getHead();
        deleteDuplicate1(head);

        printLinkedList();
    }

    private static void printLinkedList() {
        Node n = getHead().next;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    private static void deleteDuplicate1(Node head) {
        Hashtable<Integer, Integer> table = new Hashtable<>();
        Node tmp = head.next;
        Node pre = null;
        while (tmp != null) {
            if (table.containsKey(tmp.data)) {
                pre.next = tmp.next;
            } else {
                table.put(tmp.data, 1);
                pre = tmp;
            }
            tmp = tmp.next;
        }
    }

    private static void deleteDuplicate(Node head) {
        Node p = head.next;
        while (p != null) {
            // p就是外层循环的当前节点
            Node q = p;
            while (q.next != null) {
                if (p.data == q.next.data) {
                    // 删除这个节点
                    q.next = q.next.next;
                } else {
                    // 跳到下一个节点
                    q = q.next;
                }
            }
            p = p.next;
        }
    }

    private static void deleteDuplicate2(Node head) {
        Node p = head.next;
        while (p != null) {
            Node q = head;
            while (q.next != p) {
                if (p.data == q.next.data) {
                    q.next = q.next.next;
                    break;
                }
                q = q.next;
            }
            p = p.next;
        }
    }

    private static Node getHead() {
        return head;
    }


}

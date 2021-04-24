package com.chapter8.section1.subject3;

/**
 * @author Liu
 * @date 2021/3/13 13:52
 * <p>
 * 如何从链表中删除重复数据？
 */
public class Main {


    private static Node node1;

    static {
        node1 = new Node(1);
        Node node2 = new Node(5);
        Node node3 = new Node(6);
        Node node4 = new Node(2);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
    }

    public static void main(String[] args) {
        Node head = getHead();
        Node n = findElem(head, 3);
        System.out.println(n);
    }

    private static Node findElem(Node head, int k) {
        if (k < 1) {
            // 如果k小于1，返回null
            return null;
        }

        // 双指针
        Node p1 = head;
        Node p2 = head;
        // p1前移k - 1步
        for (int i = 0; i < k - 1 && p1 != null; i++) {
            p1 = p1.next;
        }
        // 检测有没有越界
        if (p1 == null) {
            System.out.println("k不合法");
            return null;
        }
        // 两个指针同时往后移，直到p1为空的时候p2就是倒数第k个结点了
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    private static Node getHead() {
        return node1;
    }

}

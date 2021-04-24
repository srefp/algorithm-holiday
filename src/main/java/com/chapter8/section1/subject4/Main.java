package com.chapter8.section1.subject4;

/**
 * @author Liu
 * @date 2021/3/13 13:52
 * <p>
 * 如何实现链表的反转
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
        reverseIteratively(head);

        head = getHead();
        Node n = head;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    private static void reverseIteratively(Node head) {
        Node pReversedHead = head;
        Node pNode = head;
        Node pPrev = null;

        while (pNode != null) {
            Node pNext = pNode.next;
            if (pNext == null) {
                pReversedHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }

        node1 = pReversedHead;
    }


    private static Node getHead() {
        return node1;
    }

}

package com.chapter8.section1.subject1;

/**
 * @author Liu
 * @date 2021/3/15 10:12
 */
public class MyLinkedList {

    /**
     * 链表头的引用
     */
    Node head = null;

    /**
     * 向链表中插入数据
     * @param d 插入数据的内容
     */
    public void addNode(int d) {
        // 创建结点
        Node newNode = new Node(d);

        // 如果是第一个结点，之间让head指向新生成的结点并返回
        if (head == null) {
            head = newNode;
            return;
        }

        // 让tmp指向第一个结点
        Node tmp = head;
        // 遍历，直到tmp指向最后一个结点
        while (tmp.next != null) {
            tmp = tmp.next;
        }

        // 将结点添加到链表尾部
        tmp.next = newNode;
    }

    public Boolean deleteNode(int index) {
        // 删除元素的位置不合理
        if (index < 1 || index > length()) {
            return false;
        }

        // 删除列表第一个元素
        if (index == 1) {
            head = head.next;
            return true;
        }
        int i = 2;
        Node preNode = head;
        Node curNode = preNode.next;
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return true;
    }

    /**
     * @return 返回结点的长度
     */
    public int length() {
        int length = 0;
        Node tmp = head;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return length;
    }

    /**
     * 对链表进行排序
     * 返回排序后的头节点
     */
    public Node orderList() {
        // 下一个节点
        Node nextNode = null;
        // 用于交换数据
        int temp = 0;
        // 当前节点
        Node curNode = head;
        // 只要当前节点不是尾节点
        while (curNode.next != null) {
            // 初始化nextNode是当前节点的下一个节点
            nextNode = curNode.next;
            // nextNode遍历到尾节点
            while (nextNode != null) {
                // 如果当前节点的数据大于nextNode的数据
                if (curNode.data > nextNode.data) {
                    // 交换
                    temp = curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = temp;
                }
                // nextNode往后移
                nextNode = nextNode.next;
            }
            // curNode往后移
            curNode = curNode.next;
        }
        return head;
    }

    public void printList() {
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addNode(5);
        list.addNode(3);
        list.addNode(1);

        System.out.println("listLen = " + list.length());
        System.out.println("before order:");
        list.printList();
        list.orderList();
        System.out.println("after order:");
        list.printList();
    }

}

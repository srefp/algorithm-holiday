package com.chapter8.section1.subject3;

/**
 * @author Liu
 * @date 2021/3/13 13:53
 */
public class Node {

    public int data;

    public Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}

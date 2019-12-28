package com.han.leetcode.graph.base;

public class Node<T> {
    private Node next;
    private T value;

    public Node(T value) {
        this.value = value;
    }

    public Node(Node next, T value) {
        this.next = next;
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public Node setNext(Node next) {
        this.next = next;
        return next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

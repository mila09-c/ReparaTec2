package com.example.reparatec2.structures;

import java.util.ArrayList;
import java.util.List;

public class CustomStack<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> top;
    private int size = 0;

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public List<T> toList() {
        List<T> list = new ArrayList<>();
        Node<T> current = top;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }

    public int size() { return size; }
}
package com.zizitop.course.utils;

import java.util.Arrays;

/**
 *
 *  { } - node
 *
 *   {tail|head}
 *   {tail} <-> {head}
 *   {tail} <-> {2} <->  {3}  <-> {4} <-> {head}
 *
 */
public class DynamicLinkedList {

    private Node head;
    private Node tail;

    public void add(Object object){
        Node node = new Node(object);
        if (head == null){
            this.head = node;
            this.tail = node;
        } else {
            head.next = node;
            head = node;
        }
        headIndex++;
    }

    public Object get(int idx){
        return null;
    }

    public Object remove(int idx){
        return null;
    }


    private class Node {
        Object object; //payload
        Node next;

        public Node(Object object) {
            this.object = object;
        }

    }
}

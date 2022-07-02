package com.zizitop.course.utils;

import java.util.Arrays;

/**
 *
 *  { } - node
 *   {head} <-> {2} <->  {3}  <->  {tail}
 */
public class DynamicLinkedList {

    private Node head;
    private Node tail;

    public void add(Object object){

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
        Node previous;
    }
}

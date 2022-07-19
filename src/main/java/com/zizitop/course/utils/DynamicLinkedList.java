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
public class DynamicLinkedList implements MyList {

    private Node head;
    private Node tail;
    int headIndex;

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

    private Node getNode(int idx){
        Node result = tail;
        for(int i = 1; i <= idx; i++) {
            result = result.next;
        }
        return result;
    }

    public Object get(int idx){
        return getNode(idx).object;
    }

    public Object remove(int idx){
        if(idx == 0){ // for "Tail"
           tail = getNode(1);
        }else if(idx == headIndex){ // for "Head"
          head = getNode(idx - 1);
        }else{
            getNode(idx - 1).next = getNode(idx + 1);
        }
        Object object = get(idx);
        getNode(idx - 1).next = getNode(idx + 1);
        return object;

        // написать тест для всех трех случаев remove
    }


    private class Node {
        Object object; //payload
        Node next;

        public Node(Object object) {
            this.object = object;
        }

    }
}

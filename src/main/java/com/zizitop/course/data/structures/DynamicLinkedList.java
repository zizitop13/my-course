package com.zizitop.course.data.structures;

import com.zizitop.course.data.MyList;

/**
 *
 *  { } - node
 *
 *   {tail|head}
 *   {tail} <-> {head}
 *   {tail} <-> {2} <->  {3}  <-> {4} <-> {head}
 *
 */
public class DynamicLinkedList<T> implements MyList<T> {

    private Node head;
    private Node tail;
    int headIndex;

    public void add(T object){
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

    public T get(int idx){
        Node node = getNode(idx);
        if(node == null){
            return null;
        }
        return getNode(idx).object;
    }

    public T remove(int idx){
        T removed = get(idx);
        if(idx == 0){ // for "Tail"
           tail = getNode(1);
        }else if(idx == headIndex){ // for "Head"
          head = getNode(idx - 1);
        }else{
            getNode(idx - 1).next = getNode(idx + 1);
        }
        return removed;
    }


    private class Node {
        T object; //payload
        Node next;

        public Node(T object) {
            this.object = object;
        }

    }
}

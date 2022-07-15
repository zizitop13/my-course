package com.zizitop.course.utils;

public class ListTest {

    public static void main(String[] args) {
        testAdd(new DynamicArrayList());
        testAdd(new DynamicLinkedList());
    }

    private static void testAdd(MyList list){
        //Given
        Object obj = new Object();
        //When
        list.add(obj);
        //Then
        if(list.get(0) != obj){
            throw new AssertionError();
        }
    }
}

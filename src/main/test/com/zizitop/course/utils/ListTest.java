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

    private static void testRemoveOnlyOne(MyList list){
        // Given
        int idx = 0;
        // When
        Object removedObj = list.remove(idx);
        // Then
        assertTrue(removedObj == obj && list.get(idx) == null );
    }


    private static void testRemoveFromFirst(MyList list){
        //TODO
    }

    private static void testRemoveFromMiddle(MyList list){
        //TODO
    }

    private static void testRemoveFromEnd(MyList list){
        //TODO
    }

    private static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError();
        }
    }

}

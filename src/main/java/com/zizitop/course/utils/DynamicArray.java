package com.zizitop.course.utils;

import java.util.Arrays;

public class DynamicArray {

    private Object[] array;
    private int headIndex;


    public DynamicArray(){     //    0     1
        array = new Object[2]; // { 1, 2 }
    }

    /**
     * Polymorphism
     * @param object
     */
    public void add(Object object){
        if (headIndex == array.length){
            array = Arrays.copyOf(array, headIndex*2);
        }
        array[headIndex++] = object;
    }

    public Object get(int idx){
        return array[idx] ;
    }

    public Object remove(int idx){
        return null;
    }

    @Override
    public String toString() {
        return "";
    }
}

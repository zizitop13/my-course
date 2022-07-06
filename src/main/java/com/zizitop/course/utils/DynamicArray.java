package com.zizitop.course.utils;

import java.util.Arrays;

public class DynamicArray {

    private Object[] array;
    private int headIndex;


    public DynamicArray(){     //    0  1  2  3
        array = new Object[10]; // { 1, 2, null, 4, 5, 6 }
    }

    /**
     * Polymorphism
     * @param object
     */
    public void add(Object object){
        if (headIndex == array.length){
            array = Arrays.copyOf(array, headIndex * 3 / 2);
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
        String str = "";
        for (Object obj : array) {
            if (obj != null) {
                str += obj.toString() + " , ";
            }
        }
        return str;
    }
}

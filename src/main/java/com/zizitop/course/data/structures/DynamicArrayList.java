package com.zizitop.course.data.structures;

import com.zizitop.course.data.MyList;

import java.util.Arrays;

public class DynamicArrayList<T> implements MyList<T> {  // отнаследовались, но на собеседовании так не говорить. сказать "реализовали", "имплементировали"

    private Object[] array;
    private int headIndex;



    public DynamicArrayList() {     //    0  1  2  3
        array = new Object[10]; // { 1, 2, null, 4, 5, 6 }
    }

    /**
     * Polymorphism
     *
     * @param object
     */
    public void add(T object) {
        if (headIndex == array.length) {
            array = Arrays.copyOf(array, headIndex * 3 / 2);
        }
        array[headIndex++] = object;
    }

    public T get(int idx) {
        return (T) array[idx];
    }

    public T remove(int idx) {
        T removed = (T) array[idx];
        array[idx] = null;
        return removed;
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

    public int size() {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                count++;
            }

        }
        return count;
    }
    public int length(){
        return array.length;
    }

    public void add(int idx, T entry) {
        if (headIndex == array.length) {
            array = Arrays.copyOf(array, headIndex * 3 / 2);
        }
        array[idx] = entry;
        headIndex++;
    }
}

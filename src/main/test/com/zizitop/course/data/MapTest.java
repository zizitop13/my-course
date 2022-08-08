package com.zizitop.course.data;

import com.zizitop.course.data.structures.HashTable;

public class MapTest {

    public static void main(String[] args) {
        testPut(new HashTable<>(), "Maksim", 3);
        testPut(new HashTable<>(), 10, "Irina");
    }

    private static <K,V> void testPut(MyKeyValue<K, V> map, K key, V value){
        //When
        map.put(key, value);
        //Then
        assertTrue(map.get(key).equals(value));
    }

    private static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError();
        }
    }

}

package com.zizitop.course.data;

import com.zizitop.course.data.structures.HashTable;
import framework.Test;

public class MapTest {

    @Test
    public void putIntoHashTable_withIntegerKeyAndStringValue_expectedPutted(){
        testPut(new HashTable<>(), 10, "Irina");
    }

    private <K,V> void testPut(MyKeyValue<K, V> map, K key, V value){
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

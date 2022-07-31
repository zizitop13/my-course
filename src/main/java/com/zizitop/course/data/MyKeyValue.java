package com.zizitop.course.data;

public interface MyKeyValue<K, V> {
    void put(K key, V value);
    V get(K key);
    V remove(K key);
}

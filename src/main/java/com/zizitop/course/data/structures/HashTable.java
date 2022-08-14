package com.zizitop.course.data.structures;

import com.zizitop.course.data.MyKeyValue;

public class HashTable<K, V> implements MyKeyValue<K, V> {

    private DynamicArrayList<Entry> dynamicArray;

    public HashTable() {
        dynamicArray = new DynamicArrayList<>();
    }

    @Override
    public void put(K key, V value) {
        int hash = key.hashCode();
        int idx = hash % dynamicArray.length();
        if(idx<0){
            idx = -idx;
        }

        Entry existed = dynamicArray.get(idx); //collision
        Entry newEntry = new Entry(key, value);
        if (existed != null) {
            existed.next = newEntry;
        } else {
            dynamicArray.add(idx, newEntry);
        }
    }

    @Override
    public V get(K key) {
        int hash = key.hashCode();
        int idx = hash % dynamicArray.length();
        if(idx<0) {
            idx = -idx;
        }

        Entry entry = dynamicArray.get(idx);

        while(entry != null && !key.equals(entry.key)){
            entry = entry.next;
        }

        if (entry == null) {
            return null;
        }

        return entry.value;

    }

    @Override
    public V remove(K key) {
        return null;
    }

    private class Entry {
        private K key;
        private V value;
        private Entry next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        V getValue() {
            return value;
        }
    }
}

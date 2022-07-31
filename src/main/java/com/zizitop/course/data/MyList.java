package com.zizitop.course.data;

public interface MyList<T> {
    void add(T object);
    T get(int idx);
    T remove(int idx);
}

package com.zizitop.course.se.data.orm;

public interface Converter<T, S> {
    T convert(S source);
    Class<S> getSourceType();
}

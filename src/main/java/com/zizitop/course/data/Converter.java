package com.zizitop.course.data;

public interface Converter<T, S> {
    T convert(S source);
    Class<S> getSourceType();
}

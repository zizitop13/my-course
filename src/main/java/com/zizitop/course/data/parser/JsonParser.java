package com.zizitop.course.data.parser;

public interface JsonParser {
    <T> T parse(String payload, Class<T> clazz);
}

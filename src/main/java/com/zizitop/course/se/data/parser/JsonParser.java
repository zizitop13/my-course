package com.zizitop.course.se.data.parser;

import java.io.IOException;

public interface JsonParser {
    <T> T parse(String payload, Class<T> clazz) throws IOException, NoSuchFieldException, IllegalAccessException;
}

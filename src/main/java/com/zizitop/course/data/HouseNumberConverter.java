package com.zizitop.course.data;

import com.zizitop.course.data.model.HouseNumber;

public class HouseNumberConverter implements Converter<HouseNumber, String> {

    @Override
    public HouseNumber convert(String source) {
        return new HouseNumber(source);
    }

    @Override
    public Class<String> getSourceType() {
        return String.class;
    }
}

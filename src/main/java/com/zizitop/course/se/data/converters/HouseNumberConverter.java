package com.zizitop.course.se.data.converters;

import com.zizitop.course.se.data.model.HouseNumber;
import com.zizitop.course.se.data.orm.Converter;

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

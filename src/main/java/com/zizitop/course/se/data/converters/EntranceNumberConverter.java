package com.zizitop.course.se.data.converters;

import com.zizitop.course.se.data.model.EntranceNumber;
import com.zizitop.course.se.data.orm.Converter;

public class EntranceNumberConverter implements Converter<EntranceNumber, Integer> {
    @Override
    public EntranceNumber convert(Integer source) {
        return new EntranceNumber(source);
    }

    @Override
    public Class<Integer> getSourceType() {
        return Integer.class;
    }
}

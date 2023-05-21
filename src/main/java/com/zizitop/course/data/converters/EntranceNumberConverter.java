package com.zizitop.course.data.converters;

import com.zizitop.course.data.model.EntranceNumber;
import com.zizitop.course.data.orm.Converter;

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

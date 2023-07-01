package com.zizitop.course.se.data.converters;

import com.zizitop.course.se.data.model.Street;
import com.zizitop.course.se.data.orm.Converter;

public class StreetConverter implements Converter<Street, String> {

    @Override
    public Street convert(String source) {
        return new Street(source);
    }

    @Override
    public Class<String> getSourceType() {
        return String.class;
    }
}

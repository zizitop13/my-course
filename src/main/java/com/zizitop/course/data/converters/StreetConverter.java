package com.zizitop.course.data.converters;

import com.zizitop.course.data.model.Street;
import com.zizitop.course.data.orm.Converter;

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

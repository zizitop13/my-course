package com.zizitop.course.data;

import com.zizitop.course.data.model.Street;

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

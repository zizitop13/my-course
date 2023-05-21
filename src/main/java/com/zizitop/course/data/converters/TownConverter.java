package com.zizitop.course.data.converters;

import com.zizitop.course.data.model.Town;
import com.zizitop.course.data.orm.Converter;

public class TownConverter implements Converter<Town, String> {

    @Override
    public Town convert(String source) {
        return new Town(source);
    }

    @Override
    public Class<String> getSourceType() {
        return String.class;
    }
}

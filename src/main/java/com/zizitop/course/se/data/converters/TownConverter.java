package com.zizitop.course.se.data.converters;

import com.zizitop.course.se.data.model.Town;
import com.zizitop.course.se.data.orm.Converter;

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

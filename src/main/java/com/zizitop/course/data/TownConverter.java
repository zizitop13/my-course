package com.zizitop.course.data;

import com.zizitop.course.data.model.Town;

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

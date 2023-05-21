package com.zizitop.course.data.model;

import com.zizitop.course.data.converters.TownConverter;
import com.zizitop.course.data.orm.ValueObject;

import java.security.InvalidParameterException;

@ValueObject(converter = TownConverter.class)
public class Town {
    private final String name;

    public Town (String name){
        if(name != null && !name.isBlank()){
            this.name = name;
        }else{
            throw new InvalidParameterException("Town: this field cannot be empty");
        }
    }

    @Override
    public String toString() {
        return "Town{" +
                "name='" + name + '\'' +
                '}';
    }
}

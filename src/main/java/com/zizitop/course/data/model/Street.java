package com.zizitop.course.data.model;

import com.zizitop.course.data.converters.StreetConverter;
import com.zizitop.course.data.orm.ValueObject;

import java.security.InvalidParameterException;

@ValueObject(converter = StreetConverter.class)
public class Street {
    private final String name;
            public Street (String name){
                if(name != null && !name.isBlank()){
                    this.name = name;
                }else{
                    throw new InvalidParameterException("Street: this field cannot be empty");
                }
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                '}';
    }
}

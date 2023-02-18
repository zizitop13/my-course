package com.zizitop.course.data.model;

import java.security.InvalidParameterException;

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

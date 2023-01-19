package com.zizitop.course.data.model;

import java.security.InvalidParameterException;

public class Town {
    private final String name;

    public Town (String name){
        if(name != null && !name.isBlank()){
            this.name = name;
        }else{
            throw new InvalidParameterException("Town: this field cannot be empty");
        }
    }
}

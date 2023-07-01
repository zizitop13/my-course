package com.zizitop.course.se.data.model;

import com.zizitop.course.se.data.converters.HouseNumberConverter;
import com.zizitop.course.se.data.orm.ValueObject;

import java.security.InvalidParameterException;

@ValueObject(converter = HouseNumberConverter.class)
public class HouseNumber {
    private final String number;

    public HouseNumber(String number){
        if(number != null && !number.isBlank()){
            this.number = number;
        }else{
            throw new InvalidParameterException("Number: this field cannot be empty");
        }
    }

    public String getNumber(){
        return number;
    }

    @Override
    public String toString() {
        return "HouseNumber{" +
                "number='" + number + '\'' +
                '}';
    }
}

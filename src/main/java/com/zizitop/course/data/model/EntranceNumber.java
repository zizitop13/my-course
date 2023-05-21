package com.zizitop.course.data.model;

import com.zizitop.course.data.converters.EntranceNumberConverter;
import com.zizitop.course.data.orm.ValueObject;

import java.security.InvalidParameterException;

@ValueObject(converter = EntranceNumberConverter.class)
public class EntranceNumber {
    private final int number;

    public EntranceNumber(int number) throws InvalidParameterException {

        if(number>0){
            this.number = number;
        }else {
            throw new InvalidParameterException("Number should be positive");
        }
    }

    public int getNumber(){
        return number;
    }
}

package com.zizitop.course.data.model.numbers;

import java.security.InvalidParameterException;

public class FlatNumber {
    private final int number;

    public FlatNumber(int number){
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

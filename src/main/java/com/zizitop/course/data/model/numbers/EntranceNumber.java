package com.zizitop.course.data.model.numbers;

import java.security.InvalidParameterException;

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

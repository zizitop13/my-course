package com.zizitop.course.data.model;

import java.security.InvalidParameterException;

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

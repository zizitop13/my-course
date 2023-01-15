package com.zizitop.course.data.model;

import java.security.InvalidParameterException;

public class HouseAddress {
    private String town;
    private String street;
    private String number;
    public HouseAddress(String town, String street, String number){
        if(town != null && !town.isBlank()){
            this.town = town;
        }else{
            throw new InvalidParameterException("Town: this field cannot be empty");
        }
        if (street != null){
            this.street = street;
        }else{
            throw new InvalidParameterException("Street: this field cannot be empty");
        }
        if(number != null){
            this.number = number;
        }else{
            throw new InvalidParameterException("Number: this field cannot be empty");
        }
    }
}

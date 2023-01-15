package com.zizitop.course.data.model;

import java.security.InvalidParameterException;

public class HouseAddress {
    private Town town;
    private Street street;
    private HouseNumber number;
    public HouseAddress(Town town, Street street, HouseNumber number){
        this.town = town;
        this.street = street;
        this.number = number;

    }
}

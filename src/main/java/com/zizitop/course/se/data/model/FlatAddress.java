package com.zizitop.course.se.data.model;

public class FlatAddress {
    private HouseAddress houseAddress;
    private FlatNumber flatNumber;

    public FlatAddress(HouseAddress houseAddress, FlatNumber flatNumber) {
        this.houseAddress = houseAddress;
        this.flatNumber = flatNumber;
    }

}

package com.zizitop.course.se.data.model;

public class Flat {

    private FlatNumber number;
    private Entrance entrance;

    public FlatAddress flatAddress(){
        return new FlatAddress(entrance.getHouseAddress(), number);
    }
}

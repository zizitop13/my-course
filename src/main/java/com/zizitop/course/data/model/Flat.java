package com.zizitop.course.data.model;

public class Flat {

    private FlatNumber number;
    private Entrance entrance;

    public FlatAddress flatAddress(){
        return new FlatAddress(entrance.getHouseAddress(), number);
    }
}

package com.zizitop.course.data.model;

import java.util.List;

public class Entrance {
    private EntranceNumber number;
    private List<Flat> flats;
    private House house;

    public Entrance(EntranceNumber number){
        this.number = number;
    }

    public House getHouse() {
        return house;
    }

    public HouseAddress getHouseAddress() {
        return house.getHouseAddress();
    }
}

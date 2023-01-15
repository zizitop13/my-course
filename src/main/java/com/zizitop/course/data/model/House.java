package com.zizitop.course.data.model;


import java.util.List;

public class House {
    private HouseAddress houseAddress;
    private List<Entrance> entrances;

    public House(HouseAddress houseAddress){
        this.houseAddress = houseAddress;
    }

    public void setEntrances(List<Entrance> entrance){
        this.entrances = entrance;
    }

    public HouseAddress getHouseAddress() {
        return houseAddress;
    }
}

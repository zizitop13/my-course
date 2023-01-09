package com.zizitop.course.data.model;


import java.util.List;

public class House {
    private Address address;
    private List<Entrance> entrances;

    public House(Address address){
        this.address = address;
    }

    public void setEntrances(List<Entrance> entrance){
        this.entrances = entrance;
    }
}

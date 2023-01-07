package com.zizitop.course.data.model;


import java.util.List;

public class House {
    private String address;
    private List<Entrance> entrances;

    public House(String address){
        this.address = address;
    }

    public void setEntrances(List<Entrance> entrance){
        this.entrances = entrance;
    }
}

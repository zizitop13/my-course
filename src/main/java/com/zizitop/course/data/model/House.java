package com.zizitop.course.data.model;


import java.util.List;

public class House {

    private long id;

    private HouseAddress houseAddress;
    private List<Entrance> entrances;

    public House(HouseAddress houseAddress){
        this.houseAddress = houseAddress;
        this.id = 0l;
    }

    public void setEntrances(List<Entrance> entrance){
        this.entrances = entrance;
    }

    public HouseAddress getHouseAddress() {
        return houseAddress;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", houseAddress=" + houseAddress +
                ", entrances=" + entrances +
                '}';
    }
}

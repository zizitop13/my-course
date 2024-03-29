package com.zizitop.course.se.data.model;


import com.zizitop.course.se.data.OneToOne;

public class HouseAddress {

    private Long id;
    private Town town;
    private Street street;
    private HouseNumber number;

    @OneToOne
    private House house;

    public Long getId() {
        return id;
    }

    private HouseAddress(){}

    public HouseAddress(Long id, Town town, Street street, HouseNumber number){
        this.id = id;
        this.town = town;
        this.street = street;
        this.number = number;
    }
    
    public House registerHouse(){
        if(this.house==null){
            this.house = new House(this);
            System.out.println("HouseModel registered to address: " + this);
        }
        return this.house;
    }

    @Override
    public String toString() {
        return "HouseAddress{" +
                "town=" + town +
                ", street=" + street +
                ", number=" + number +
                ", house=" + house.getId() +
                '}';
    }
}

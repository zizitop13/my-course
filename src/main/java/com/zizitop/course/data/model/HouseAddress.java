package com.zizitop.course.data.model;


public class HouseAddress {

    private Long id;
    private Town town;
    private Street street;
    private HouseNumber number;
    
    private House house;
    
    public HouseAddress(Long id, Town town, Street street, HouseNumber number){
        this.id = id;
        this.town = town;
        this.street = street;
        this.number = number;
    }
    
    public void registerHouse(){
        if(this.house==null){
            this.house = new House(this);
            System.out.println("House registered to address: " + this);
        }
    }

    @Override
    public String toString() {
        return "HouseAddress{" +
                "town=" + town +
                ", street=" + street +
                ", number=" + number +
                ", house=" + house +
                '}';
    }
}

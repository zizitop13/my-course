package com.zizitop.course.data.repositories;

import com.zizitop.course.data.MyKeyValue;
import com.zizitop.course.data.model.House;
import com.zizitop.course.data.structures.HashTable;

public class InMemoryHouseRepository implements HouseRepository {


    private MyKeyValue <String, House> houseMap = new HashTable<>();

    @Override
    public void add(House house) {
        houseMap.put(house.address, house);
    }

    @Override
    public House get(String address) {
       return houseMap.get(address);
    }
}

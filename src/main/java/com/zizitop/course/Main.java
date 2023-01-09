package com.zizitop.course;


import com.zizitop.course.data.model.Address;
import com.zizitop.course.data.model.Entrance;
import com.zizitop.course.data.model.EntranceNumber;
import com.zizitop.course.data.model.House;

import java.util.List;

public class Main {


    //точка входа в программу
    public static void main(String[] args) {
        Address address = new Address("test", "test", "test");
        House house = new House(address);
        house.setEntrances(List.of(
                new Entrance(new EntranceNumber(1))
        ));

        //run http server

    }

}

package com.zizitop.course.se.data.repositories;

import com.zizitop.course.se.data.model.House;

public interface HouseRepository {
    void add(House house);
    House get(String address);
}

package com.zizitop.course.data.repositories;

import com.zizitop.course.data.model.House;

public interface HouseRepository {
    void add(House house);
    House get(String address);
}

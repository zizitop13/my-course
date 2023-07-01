package com.zizitop.course.se.service;

import com.zizitop.course.se.data.model.House;
import com.zizitop.course.se.service.exceptions.HouseAlreadyExistsException;

public interface HouseRegistrationService {
    void addHouse(House house) throws HouseAlreadyExistsException;
}

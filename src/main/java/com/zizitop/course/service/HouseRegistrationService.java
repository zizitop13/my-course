package com.zizitop.course.service;

import com.zizitop.course.data.model.House;
import com.zizitop.course.service.exceptions.HouseAlreadyExistsException;

public interface HouseRegistrationService {
    void addHouse(House house) throws HouseAlreadyExistsException;
}

package com.zizitop.course.service;

import com.zizitop.course.data.model.House;
import com.zizitop.course.data.repositories.HouseRepository;
import com.zizitop.course.service.exceptions.HouseAlreadyExistsException;

public class SimpleHouseRegistrationService implements HouseRegistrationService {

    private HouseRepository houseRepository;

    public SimpleHouseRegistrationService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public void addHouse(House house) throws HouseAlreadyExistsException {
        //TODO: check house contains some address, create exception
        if(houseRepository.get(house.address) != null){
            throw new HouseAlreadyExistsException();
        }
        houseRepository.add(house);
    }


    //TODO: add get method, return House by address
}

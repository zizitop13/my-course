package com.zizitop.course.spring.service;

import com.zizitop.course.spring.data.model.HouseModel;
import com.zizitop.course.spring.data.repositories.HouseRepository;
import org.springframework.stereotype.Service;

@Service
public class HouseService {
    private final HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public HouseModel findHouse(String street,String number){
        return houseRepository.findByStreetAndNumber(street, number);
    }

    public HouseModel saveHouse(String street, String number){
        System.out.println(street + ":" + number);
        HouseModel houseModel = new HouseModel();
        houseModel.setNumber(number);
        houseModel.setStreet(street);
        return houseRepository.save(houseModel);
    }
}

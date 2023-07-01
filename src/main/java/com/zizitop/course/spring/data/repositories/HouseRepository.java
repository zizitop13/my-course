package com.zizitop.course.spring.data.repositories;

import com.zizitop.course.spring.data.model.HouseModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<HouseModel, Long> {
    HouseModel findByStreetAndNumber(String street, String number);
}

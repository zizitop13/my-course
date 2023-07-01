package com.zizitop.course.spring.controllers;

import com.zizitop.course.spring.data.model.HouseModel;
import com.zizitop.course.spring.service.HouseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/house")
public class HouseRestController {

    private final HouseService houseService;

    public HouseRestController(HouseService houseService) {
        this.houseService = houseService;
    }


    @GetMapping("/filter")
    public HouseModel findHouse(@RequestParam String street, @RequestParam String number){
        return houseService.findHouse(street, number);
    }

    @PostMapping("/save")
    public HouseModel saveHouse(@RequestParam String street, @RequestParam String number){
        System.out.println(street + ":" + number);
        return houseService.saveHouse(street, number);
    }
}

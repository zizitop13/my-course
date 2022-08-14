package com.zizitop.course;

import com.zizitop.course.data.repositories.HouseRepository;
import com.zizitop.course.data.repositories.InMemoryHouseRepository;
import com.zizitop.course.data.structures.DynamicArrayList;
import com.zizitop.course.data.model.Entrance;
import com.zizitop.course.data.model.House;
import com.zizitop.course.data.MyList;
import com.zizitop.course.service.HouseRegistrationService;
import com.zizitop.course.service.SimpleHouseRegistrationService;
import com.zizitop.course.service.exceptions.HouseAlreadyExistsException;

public class Main {


    //точка входа в программу
    public static void main(String[] args) throws InterruptedException {

        //объект - экземпляр класса Channel
        //javaCodeChannel ссылка на объект
        House house = new House();

        Entrance entrance = new Entrance();
        entrance.entranceNumber = 1;

        Entrance entrance1 = new Entrance();
        entrance1.entranceNumber = 2;

        Entrance entrance2 = new Entrance();
        entrance2.entranceNumber = 3;

        MyList<Entrance> enteranceList = new DynamicArrayList<>();
        enteranceList.add(entrance);
        enteranceList.add(entrance1);
        enteranceList.add(entrance2);
        house.setEntrances(enteranceList);

        HouseRepository houseRepository = new InMemoryHouseRepository();
        HouseRegistrationService houseRegistrationService = new SimpleHouseRegistrationService(houseRepository);
        try {
            houseRegistrationService.addHouse(house);
        } catch (HouseAlreadyExistsException e) {
            e.printStackTrace();
        }

    }

}

package com.zizitop.course;

import com.zizitop.course.data.structures.DynamicArrayList;
import com.zizitop.course.model.Entrance;
import com.zizitop.course.model.House;
import com.zizitop.course.data.structures.DynamicLinkedList;
import com.zizitop.course.data.MyList;

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

        Entrance object = enteranceList.get(2);
        Entrance removed = enteranceList.remove(1);

        System.out.println(removed.entranceNumber);
        System.out.println(object.entranceNumber);
        System.out.println(enteranceList);

    }

}

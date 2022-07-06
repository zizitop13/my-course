package com.zizitop.course;

import com.sun.net.httpserver.HttpServer;
import com.zizitop.course.model.Entrance;
import com.zizitop.course.model.House;
import com.zizitop.course.utils.DynamicArray;
import com.zizitop.course.utils.DynamicLinkedList;

import java.util.Arrays;
import java.util.Scanner;

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


        DynamicArray enteranceList = new DynamicArray();
//        DynamicLinkedList enteranceList = new DynamicLinkedList();


        enteranceList.add(entrance);
        enteranceList.add(entrance1);
        enteranceList.add(entrance2);

        Object object = enteranceList.get(2);
        Object removed = enteranceList.remove(1);

        System.out.println(removed);
        System.out.println(object);
        System.out.println(enteranceList);

//        int number = 2;
//        Entrance[] entrances = new Entrance[number];
//        entrances[0] = new Entrance();
//        entrances[1] = new Entrance();
//
//                Entrance[] newEntrances = Arrays.copyOf(entrances, 3);
//        entrances = newEntrances;
//        entrances[2] = new Entrance();
//
//        house.setEntrances(entrances);


        Scanner scanner = new Scanner(System.in);

        while (true){
            Thread.sleep(1000);
            System.out.println("I'm working");

            String line = scanner.nextLine();
            // не равно   и  строка равна слову "exit"
            if(line!=null && line.equals("exit")){
                break;
            } else {
                System.out.println("Warning, unknown word: " + line);
            }
        }

        System.out.println("I'm done");
    }

}

package com.zizitop.course;

import com.zizitop.course.model.Entrance;
import com.zizitop.course.model.House;

import java.util.Arrays;
import java.util.Scanner;

public class Main {


    //точка входа в программу
    public static void main(String[] args) throws InterruptedException {
        //объект - экземпляр класса Channel
        //javaCodeChannel ссылка на объект
        House house = new House();

        int number = 2;
        Entrance[] entrances = new Entrance[number];
        entrances[0] = new Entrance();
        entrances[1] = new Entrance();

        Entrance[] newEntrances = Arrays.copyOf(entrances, 3);
        entrances = newEntrances;
        entrances[2] = new Entrance();

        house.setEntrances(entrances);



        System.out.println(house);

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

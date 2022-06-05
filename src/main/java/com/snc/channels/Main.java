package com.snc.channels;

import com.snc.channels.model.Channel;

import java.net.URI;
import java.util.Scanner;

public class Main {


    //точка входа в программу
    public static void main(String[] args) throws InterruptedException {
        //объект - экземпляр класса Channel
        //javaCodeChannel ссылка на объект
        Channel javaCodeChannel = new Channel();
        javaCodeChannel.setId(1);
        javaCodeChannel.setCount(100);
        javaCodeChannel.setName("Java Code");
        javaCodeChannel
                .setLink(URI.create("https://youtube.com/java_code"));
        System.out.println(javaCodeChannel);

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

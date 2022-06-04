package com.snc.channels;

import com.snc.channels.model.Channel;

import java.net.URI;

public class Main {


    //точка входа в программу
    public static void main(String[] args) throws InterruptedException {
        //объект - экземпляр класса Channel
        //javaCodeChannel ссылка на объект
        Channel javaCodeChannel = new Channel();
        javaCodeChannel.setCount(100);
        javaCodeChannel.setName("Java Code");
        javaCodeChannel
                .setLink(URI.create("https://youtube.com/java_code"));
        System.out.println(javaCodeChannel);

        int i = 0;
        while (i < 10){
            i++;
            Thread.sleep(1000);
            System.out.println("I'am working");
        }
    }

}

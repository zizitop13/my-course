package com.zizitop.course;


import com.zizitop.course.data.model.Address;
import com.zizitop.course.data.model.Entrance;
import com.zizitop.course.data.model.numbers.EntranceNumber;
import com.zizitop.course.data.model.House;

import java.security.InvalidParameterException;
import java.util.List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Main {


    //точка входа в программу
    public static void main(String[] args) throws InvalidParameterException {

        House house = new House(new Address("test", "test", "test"));
        house.setEntrances(List.of(
                new Entrance(new EntranceNumber(1))
        ));


        //run http server

        // код сервера честно стащен с хабра, с попыткой осмыслить происходящее, разумеется.
        // исходные комментарии сохранены

        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started!");

            while (true) {
                // ожидаем подключения
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // для подключившегося клиента открываем потоки
                // чтения и записи
                try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                     PrintWriter output = new PrintWriter(socket.getOutputStream())) {

                    // ждем первой строки запроса
                    while (!input.ready()) ;

                    // считываем и печатаем все что было отправлено клиентом
                    System.out.println();
                    while (input.ready()) {
                        System.out.println(input.readLine());
                    }

                    // отправляем ответ
                    output.println("HTTP/1.1 200 OK");
                    output.println("Content-Type: text/html; charset=utf-8");
                    output.println();
                    output.println("<p>Server is working</p>");
                    output.flush();

                    // по окончанию выполнения блока try-with-resources потоки,
                    // а вместе с ними и соединение будут закрыты
                    System.out.println("Client disconnected!");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}

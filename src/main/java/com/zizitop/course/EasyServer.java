package com.zizitop.course;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EasyServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8081);
        Socket input = serverSocket.accept();
        Scanner in = new Scanner(input.getInputStream());
        while(in.hasNext()){
            System.out.println(in.nextLine());

        }
        in.close();
        input.close();
        serverSocket.close();
    }
}

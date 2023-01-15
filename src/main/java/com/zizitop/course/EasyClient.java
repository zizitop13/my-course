package com.zizitop.course;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EasyClient  {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("localhost",8081);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println("Server work's");
        out.println("It's OK");

        out.close();
        socket.close();
    }
}

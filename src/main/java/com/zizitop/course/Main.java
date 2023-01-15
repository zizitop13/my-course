package com.zizitop.course;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Main {


    //точка входа в программу
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/test", new ExceptionHandler());
        server.createContext("/test2", new MyHandler2());
        server.setExecutor(Executors.newFixedThreadPool(256)); // creates a default executor
        server.start();

    }
    public static class ExceptionHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "<p>This is the response1<p>";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }


    public static class MyHandler2 implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "<p>This is the response2<p>";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}

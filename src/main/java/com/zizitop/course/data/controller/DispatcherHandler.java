package com.zizitop.course.data.controller;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class DispatcherHandler implements HttpHandler {

    private final Map<HttpMapping, HttpController> controllerMap = new HashMap<>();

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        HttpMapping httpMapping = HttpMapping.fromExchange(exchange);
        HttpController httpController = controllerMap.get(httpMapping);

        try {
            Object response = httpController.execute(null, null, null);
            String serializedResponse = serialize(response);
            exchange.sendResponseHeaders(200, serializedResponse.length());
            try(OutputStream os = exchange.getResponseBody()){
                os.write(serializedResponse.getBytes());
            }
        } catch (Exception e){
            exchange.sendResponseHeaders(500, 0);
        }
    }

    private String serialize(Object response) {
        return "";
    }


}

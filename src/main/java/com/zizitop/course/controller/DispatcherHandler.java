package com.zizitop.course.controller;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class DispatcherHandler implements HttpHandler {

    private final Map<HttpMapping, ControllerHandler> controllerMap;

    public DispatcherHandler(Map<HttpMapping, ControllerHandler> controllerMap) {
        this.controllerMap = controllerMap;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        try (OutputStream os = exchange.getResponseBody()) {
            String serializedResponse = "";
            try {
                HttpMapping httpMapping = HttpMapping.fromExchange(exchange);
                ControllerHandler controllerHandler = controllerMap.get(httpMapping);

                if (controllerHandler == null) {
                    throw new IOException("Controller for mapping " + httpMapping + " not found");
                }

                //TODO: extract body, params, headers
                Object body = extractBody(exchange);
                Map<String, String> params = extractParams(exchange);
                Map<String, String> headers = extractHeaders(exchange);

                Object response = controllerHandler.execute(body, params, headers);
                serializedResponse = serialize(response);
                exchange.sendResponseHeaders(200, serializedResponse.length());
            } catch (Exception e) {
                serializedResponse = e.getMessage();
                exchange.sendResponseHeaders(500, serializedResponse.length());
            } finally {
                os.write(serializedResponse.getBytes());
            }
        }
    }

    private Map<String, String> extractHeaders(HttpExchange exchange) {
        return null;
    }

    private Object extractBody(HttpExchange exchange) {
        try (InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
             BufferedReader br = new BufferedReader(isr)
        ) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, String> extractParams(HttpExchange exchange) {
        String query = exchange.getRequestURI().getQuery();

        Map<String, String> params = new HashMap<>();

        if (query == null) {
            return params;
        }

        // Разделение строки запроса на подстроки, используя знак "амперсанд".
        // Создание массива строк
        String[] split = query.split("&");

        // Циклическое перебирание строк запроса, вывод каждой подстроки на консоль.
        for (String keyValue : split) {
            String[] pair = keyValue.split("=");
            params.put(pair[0], pair[1]);
        }

        return params;
    }

    private String serialize(Object response) {
        return response.toString();
    }


}

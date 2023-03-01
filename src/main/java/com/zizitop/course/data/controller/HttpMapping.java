package com.zizitop.course.data.controller;

import com.sun.net.httpserver.HttpExchange;

public class HttpMapping {

    private final String path;
    private final METHOD method;

    public HttpMapping(String path, METHOD method) {
        this.path = path;
        this.method = method;
    }

    public static HttpMapping fromExchange(HttpExchange exchange) {
        return new HttpMapping(null,null);
    }
}

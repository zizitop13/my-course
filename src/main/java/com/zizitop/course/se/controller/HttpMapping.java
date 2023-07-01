package com.zizitop.course.se.controller;

import com.sun.net.httpserver.HttpExchange;

import java.util.Objects;

public class HttpMapping {

    private final String path;
    private final METHOD method;

    public HttpMapping(String path, METHOD method) {
        this.path = path;
        this.method = method;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HttpMapping that = (HttpMapping) o;
        return Objects.equals(path, that.path) && method == that.method;
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, method);
    }

    public static HttpMapping fromExchange(HttpExchange exchange) {
        String path = exchange.getRequestURI().getPath();
        METHOD method = METHOD.valueOf(exchange.getRequestMethod());
        return new HttpMapping(path,method);
    }

    @Override
    public String toString() {
        return "HttpMapping{" +
                "path='" + path + '\'' +
                ", method=" + method +
                '}';
    }
}

package com.zizitop.course;


import com.sun.net.httpserver.HttpServer;
import com.zizitop.course.controller.DispatcherHandler;
import com.zizitop.course.controller.DispatcherHandlerFactory;
import com.zizitop.course.data.orm.DatabaseMapper;
import com.zizitop.course.data.orm.DatabaseMapperFactory;
import com.zizitop.course.data.orm.DatabaseMapperSettings;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Main {
    
    public static final String JDBC_H2_URL =
            "jdbc:h2:tcp://localhost/~/test;"
            +"INIT=RUNSCRIPT FROM './create.sql'\\;"; // адрес базы данных

    //точка входа в программу
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // проверка наличия драйвера для работы с БД
        DatabaseMapperSettings settings = new DatabaseMapperSettings();
        settings.entitiesPackage = "com.zizitop.course.data.model";
        DatabaseMapperFactory databaseMapperFactory = new DatabaseMapperFactory(settings);
        DatabaseMapper databaseMapper = databaseMapperFactory.createDatabaseMapper();

        DispatcherHandlerFactory dispatcherHandlerFactory = new DispatcherHandlerFactory(
                "com.zizitop.course.controller.house",
                databaseMapper
        );
        DispatcherHandler dispatcherHandler = dispatcherHandlerFactory.create();

        Class.forName("org.h2.Driver");

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", dispatcherHandler);
        server.setExecutor(Executors.newFixedThreadPool(256)); // creates a default executor
        server.start();
    }



}

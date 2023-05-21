package com.zizitop.course;


import com.sun.net.httpserver.HttpServer;
import com.zizitop.course.controller.DispatcherHandler;
import com.zizitop.course.controller.DispatcherHandlerFactory;
import com.zizitop.course.controller.HttpMapping;
import com.zizitop.course.controller.METHOD;
import com.zizitop.course.controller.house.GetHouseController;
import com.zizitop.course.controller.house.PostHouseController;
import com.zizitop.course.data.orm.DatabaseMapper;
import com.zizitop.course.data.orm.DatabaseMapperFactory;
import com.zizitop.course.data.orm.DatabaseMapperSettings;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.Executors;

public class Main {
    
    public static final String JDBC_H2_URL =
            "jdbc:h2:tcp://localhost/~/test;"
            +"INIT=RUNSCRIPT FROM './create.sql'\\;"; // адрес базы данных

    //точка входа в программу
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        // проверка наличия драйвера для работы с БД
        DatabaseMapperSettings settings = new DatabaseMapperSettings();
        settings.entitiesPackage = "com.zizitop.course.data.model";
        DatabaseMapperFactory databaseMapperFactory = new DatabaseMapperFactory(settings);
        DatabaseMapper databaseMapper = databaseMapperFactory.createDatabaseMapper();

        DispatcherHandlerFactory dispatcherHandlerFactory = new DispatcherHandlerFactory(databaseMapper);
        DispatcherHandler dispatcherHandler = dispatcherHandlerFactory.createDispatcherHandler();

        Class.forName("org.h2.Driver");

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", dispatcherHandler);
        server.setExecutor(Executors.newFixedThreadPool(256)); // creates a default executor
        server.start();
    }



}

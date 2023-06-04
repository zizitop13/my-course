package com.zizitop.course;


import com.sun.net.httpserver.HttpServer;
import com.zizitop.course.config.MyConfiguration;
import com.zizitop.course.controller.DispatcherHandler;
import com.zizitop.course.controller.DispatcherHandlerFactory;
import com.zizitop.course.data.orm.DatabaseMapper;
import com.zizitop.course.data.orm.DatabaseMapperFactory;
import com.zizitop.course.data.orm.DatabaseMapperSettings;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Main {
    
    public static final String JDBC_H2_URL =
            "jdbc:h2:tcp://localhost/~/test;"
            +"INIT=RUNSCRIPT FROM './create.sql'\\;"; // адрес базы данных

    //точка входа в программу
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfiguration.class);
        DatabaseMapper databaseMapper = applicationContext.getBean(DatabaseMapper.class);
        DispatcherHandler dispatcherHandler = applicationContext.getBean(DispatcherHandler.class);

        // проверка наличия драйвера для работы с БД
        Class.forName("org.h2.Driver");
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", dispatcherHandler);
        server.setExecutor(Executors.newFixedThreadPool(256)); // creates a default executor
        server.start();
    }



}

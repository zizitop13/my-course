package com.zizitop.course;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.zizitop.course.data.model.House;
import com.zizitop.course.data.model.HouseAddress;
import com.zizitop.course.data.model.HouseNumber;
import com.zizitop.course.data.model.Street;
import com.zizitop.course.data.model.Town;
import org.h2.mvstore.tx.Transaction;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

public class Main {
    
    public static final String JDBC_H2_URL =
            "jdbc:h2:tcp://localhost/~/test;"
            +"INIT=RUNSCRIPT FROM './create.sql'\\;"; // адрес базы данных

    //точка входа в программу
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        // проверка наличия драйвера для работы с БД
        Class.forName("org.h2.Driver");
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/registerHouse", new HouseRegistrationHandler());
        server.setExecutor(Executors.newFixedThreadPool(256)); // creates a default executor
        server.start();
    }

    // Объявление публичного статического класса HouseRegistrationHandler,
    // который реализует интерфейс HttpHandler.
    public static class HouseRegistrationHandler implements HttpHandler {

        // Переопределение метода handle из интерфейса HttpHandler для обработки запросов,
        // поступающих на данный обработчик (handler).
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            System.out.println("handle");

            // Получение строки запроса из объекта HttpExchange.
            String query = exchange.getRequestURI().getQuery();

            // Разделение строки запроса на подстроки, используя знак "равно", и извлечение второй подстроки.
            String s = query.split("=")[1]; // [1] - индекс подстроки

            // Создание новой пустой HashMap для хранения параметров запроса.
            Map<String, String> params = new HashMap<>();

            // Разделение строки запроса на подстроки, используя знак "амперсанд".
            // Создание массива строк
            String[] split = query.split("&");

            // Циклическое перебирание строк запроса, вывод каждой подстроки на консоль.
            for(String keyValue : split){
                System.out.println(keyValue);
            // params.put() TODO: split keyValue add put to map
                String[] pair = keyValue.split("=");
                params.put(pair[0], pair[1]);
            }

            // Вход в блок try-with-resources, создание нового соединения с базой данных,
            // используя JDBC-URL, имя пользователя "sa" и пустой пароль.
            try (Connection conn = DriverManager.getConnection(JDBC_H2_URL, "sa", "");

                 // Создание нового объекта Statement, который используется для выполнения SQL-запросов.
                 Statement st = conn.createStatement()) {

                // Выполнение запроса "select * from HOUSE_ADDRESS" и получение результатов в объекте ResultSet.
                ResultSet resultSet = st.executeQuery("select * from HOUSE_ADDRESS");

                //TODO: add street

                /**
                 String streetFilter;
                 String houseFilter;
                 // Выполнение запроса с фильтром по STREET
                ResultSet resultSetFilter = st.executeQuery("select * from HOUSE_ADDRESS WHERE STREET='"
                 + streetFilter + "'"+"AND HOUSE='" + houseFilter + "'");

                 // не слишком уверен, что сделал именно то, что требовалось, поэтому оставляю этот
                 участок кода закомментированным.
                 */


                // Начало выполнения цикла, который перебирает все строки в ResultSet.
                while(resultSet.next()){

                    // Извлечение данных из текущей строки ResultSet и сохранение их в соответствующих переменных.
                    long id = resultSet.getLong("ID");
                    String townName = resultSet.getString("TOWN");
                    String streetName = resultSet.getString("STREET");
                    String number = resultSet.getString("NUMBER");

                    // Создание новых объектов Town, Street и HouseNumber на основе сохраненных данных.
                    Town town = new Town(townName);
                    Street street = new Street(streetName);
                    HouseNumber houseNumber = new HouseNumber(number);

                    // Создание нового объекта HouseAddress на основе извлеченных данных,
                    // регистрация нового дома и получение объекта House.
                    HouseAddress houseAddress = new HouseAddress(id, town, street, houseNumber);
                    House house = houseAddress.registerHouse();

                    // Создание нового объекта Statement для выполнения SQL-запросов,
                    // который добавляет новый дом в таблицу HOUSE.
                    try(Statement statement = conn.createStatement()){
                        statement.executeUpdate(
                                "INSERT INTO HOUSE (ID, ADDRESS_ID) " +
                                "values (" + house.getId() + "," + house.getHouseAddress().getId() + ")" );
                    }

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String response = "OK";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
       }
    }

}

package com.zizitop.course;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.zizitop.course.data.model.HouseAddress;
import com.zizitop.course.data.model.HouseNumber;
import com.zizitop.course.data.model.Street;
import com.zizitop.course.data.model.Town;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Executors;

public class Main {
    
    public static final String JDBC_H2_URL = "jdbc:h2:~/test;"
            +"INIT=RUNSCRIPT FROM './create.sql'\\;";

    //точка входа в программу
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/registerHouse", new HouseRegistrationHandler());
        server.setExecutor(Executors.newFixedThreadPool(256)); // creates a default executor
        server.start();
    }

    public static class HouseRegistrationHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            try (Connection conn = DriverManager.getConnection(JDBC_H2_URL, "sa", "");

                Statement st = conn.createStatement()) {

                ResultSet resultSet = st.executeQuery("select * from HOUSE_ADDRESS");

                while(resultSet.next()){
                    long id = resultSet.getLong("ID");
                    String townName = resultSet.getString("TOWN");
                    String streetName = resultSet.getString("STREET");
                    String number = resultSet.getString("NUMBER");

                    Town town = new Town(townName);
                    Street street = new Street(streetName);
                    HouseNumber houseNumber = new HouseNumber(number);

                    HouseAddress houseAddress = new HouseAddress(id, town, street, houseNumber);
                    houseAddress.registerHouse();

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


            String response = "OK";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}

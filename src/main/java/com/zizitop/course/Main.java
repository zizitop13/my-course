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

            System.out.println("handle");

            String query = exchange.getRequestURI().getQuery();

            String s = query.split("=")[1];

            Map<String, String> params = new HashMap<>();
            String[] split = query.split("&");
            for(String keyValue : split){
                System.out.println(keyValue);
//                params.put() TODO: split keyValue add put to map
            }

            try (Connection conn = DriverManager.getConnection(JDBC_H2_URL, "sa", "");
                Statement st = conn.createStatement()) {

                ResultSet resultSet = st.executeQuery("select * from HOUSE_ADDRESS"); //TODO: add street

                while(resultSet.next()){
                    long id = resultSet.getLong("ID");
                    String townName = resultSet.getString("TOWN");
                    String streetName = resultSet.getString("STREET");
                    String number = resultSet.getString("NUMBER");

                    Town town = new Town(townName);
                    Street street = new Street(streetName);
                    HouseNumber houseNumber = new HouseNumber(number);

                    HouseAddress houseAddress = new HouseAddress(id, town, street, houseNumber);
                    House house = houseAddress.registerHouse();

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

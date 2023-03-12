package com.zizitop.course.controller.house;

import com.zizitop.course.controller.ControllerHandler;
import com.zizitop.course.data.model.House;
import com.zizitop.course.data.model.HouseAddress;
import com.zizitop.course.data.model.HouseNumber;
import com.zizitop.course.data.model.Street;
import com.zizitop.course.data.model.Town;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import static com.zizitop.course.Main.JDBC_H2_URL;

public class GetHouseController implements ControllerHandler {
    @Override
    public Object execute(Object body, Map<String, String> params, Map<String, String> headers) {
        try (Connection conn = DriverManager.getConnection(JDBC_H2_URL, "sa", "");

             // Создание нового объекта Statement, который используется для выполнения SQL-запросов.
             Statement st = conn.createStatement()) {

            String streetFilter = params.get("street");
            String numberFilter = params.get("number");
            // Выполнение запроса с фильтром по STREET
            ResultSet resultSet = st.executeQuery("select * from HOUSE_ADDRESS WHERE STREET='"
                    + streetFilter + "'"+" AND NUMBER='" + numberFilter + "'");

            // не слишком уверен, что сделал именно то, что требовалось, поэтому оставляю этот



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
                return house;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

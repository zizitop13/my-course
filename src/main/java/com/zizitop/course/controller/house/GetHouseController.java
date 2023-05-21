package com.zizitop.course.controller.house;

import com.zizitop.course.controller.ControllerHandler;
import com.zizitop.course.data.model.House;
import com.zizitop.course.data.model.HouseAddress;
import com.zizitop.course.data.orm.DatabaseMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import static com.zizitop.course.Main.JDBC_H2_URL;
import static com.zizitop.course.controller.METHOD.GET;

@RequestMapping(method = GET, path = "/house")
public class GetHouseController implements ControllerHandler {

    private final DatabaseMapper databaseMapper;

    public GetHouseController(DatabaseMapper databaseMapper) {
        this.databaseMapper = databaseMapper;
    }

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

            // Начало выполнения цикла, который перебирает все строки в ResultSet.
            while(resultSet.next()){
                HouseAddress houseAddress = databaseMapper.map(resultSet, HouseAddress.class);
                House house = houseAddress.registerHouse();
                return house;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

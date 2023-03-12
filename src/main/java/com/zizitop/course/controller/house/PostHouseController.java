package com.zizitop.course.controller.house;

import com.zizitop.course.controller.ControllerHandler;

import java.util.Map;

public class PostHouseController implements ControllerHandler {
    @Override
    public Object execute(Object body, Map<String, String> params, Map<String, String> headers) {
        // Создание нового объекта Statement для выполнения SQL-запросов,
//                // который добавляет новый дом в таблицу HOUSE.
//                try(Statement statement = conn.createStatement()){
//                    statement.executeUpdate(
//                            "INSERT INTO HOUSE (ID, ADDRESS_ID) " +
//                                    "values (" + house.getId() + "," + house.getHouseAddress().getId() + ")" );
//                }
        return null;
    }
}

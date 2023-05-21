package com.zizitop.course.controller;

import com.zizitop.course.controller.house.GetHouseController;
import com.zizitop.course.controller.house.PostHouseController;
import com.zizitop.course.data.orm.DatabaseMapper;

import java.util.HashMap;
import java.util.Map;

public class DispatcherHandlerFactory {

    private final DatabaseMapper databaseMapper;

    public DispatcherHandlerFactory(DatabaseMapper databaseMapper) {
        this.databaseMapper = databaseMapper;
    }

    public DispatcherHandler createDispatcherHandler() {
        Map<HttpMapping, ControllerHandler> handlerMap = new HashMap<>();

        //TODO: rewrite it to package scan and init via default or "databaseMapper" constructors
        handlerMap.putAll(Map.of(
                new HttpMapping("/house", METHOD.GET), new GetHouseController(databaseMapper),
                new HttpMapping("/registerHouse", METHOD.POST), new PostHouseController())
        );

        return new DispatcherHandler(handlerMap);
    }
}

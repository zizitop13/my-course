package com.zizitop.course.controller;

import com.zizitop.course.controller.house.GetHouseController;
import com.zizitop.course.controller.house.PostHouseController;
import com.zizitop.course.controller.house.RequestMapping;
import com.zizitop.course.data.orm.Converter;
import com.zizitop.course.data.orm.DatabaseMapper;
import com.zizitop.course.data.orm.ValueObject;
import com.zizitop.course.utils.PackageScanner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DispatcherHandlerFactory {

    private final DatabaseMapper databaseMapper;

    public DispatcherHandlerFactory(DatabaseMapper databaseMapper) {
        this.databaseMapper = databaseMapper;
    }

    public DispatcherHandler createDispatcherHandler() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Map<HttpMapping, ControllerHandler> handlerMap = new HashMap<>();

        //TODO: rewrite it to package scan and init via default or "databaseMapper" constructors
        // handlerMap.putAll(Map.of(
        //       new HttpMapping("/house", METHOD.GET), new GetHouseController(databaseMapper),
        //     new HttpMapping("/registerHouse", METHOD.POST), new PostHouseController())
        //);


        List<Class<?>> classes = PackageScanner.scanPackage("controller");

        for (Class<?> cl : classes) {
            Annotation[] declaredAnnotations = cl.getDeclaredAnnotations();
            for (Annotation annotation : declaredAnnotations) {
                if (annotation instanceof RequestMapping) {
                    RequestMapping requestMapping = (RequestMapping) annotation;

                    new HttpMapping(requestMapping.path(), requestMapping.method());

                    Class<? extends ControllerHandler> controller = null;
                    Constructor<? extends ControllerHandler>[] declaredConstructors = (Constructor<? extends ControllerHandler>[]) controller.getDeclaredConstructors();
                    ControllerHandler instance;
                    for (Constructor<? extends ControllerHandler> constructor : declaredConstructors) {
                        if (constructor.getParameterCount() == 0) {
                            instance = constructor.newInstance();
                            break;
                        } else if (constructor.getParameterTypes()[0].equals(DatabaseMapper.class)) {
                            instance = constructor.newInstance(databaseMapper);
                            break;

                        }
                    }
                }
            }
        }

        return new DispatcherHandler(handlerMap);
    }
}

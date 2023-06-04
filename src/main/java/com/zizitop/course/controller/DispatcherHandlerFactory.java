package com.zizitop.course.controller;

import com.zizitop.course.controller.house.RequestMapping;
import com.zizitop.course.data.orm.DatabaseMapper;
import com.zizitop.course.utils.PackageScanner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DispatcherHandlerFactory {

    private final String packageForScan;
    private final DatabaseMapper databaseMapper;


    public DispatcherHandlerFactory(String packageForScan, DatabaseMapper databaseMapper) {
        this.packageForScan = packageForScan;
        this.databaseMapper = databaseMapper;
    }


    public DispatcherHandler create(){
        try {
            return createDispatcherHandler();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private DispatcherHandler createDispatcherHandler() throws InvocationTargetException, InstantiationException, IllegalAccessException {

        Map<HttpMapping, ControllerHandler> handlerMap = new HashMap<>();
        List<Class<?>> classes = PackageScanner.scanPackage(packageForScan);

        for (Class<?> cl : classes) {

            Annotation[] declaredAnnotations = cl.getDeclaredAnnotations();

            for (Annotation annotation : declaredAnnotations) {
                if (annotation instanceof RequestMapping) {
                    RequestMapping requestMapping = (RequestMapping) annotation;

                    HttpMapping httpMapping = new HttpMapping(requestMapping.path(), requestMapping.method());//

                    Constructor<? extends ControllerHandler>[] declaredConstructors = (Constructor<? extends ControllerHandler>[]) cl
                            .getDeclaredConstructors();

                    ControllerHandler instance = null;
                    for (Constructor<? extends ControllerHandler> constructor : declaredConstructors) {
                        if (constructor.getParameterCount() == 0) {
                            instance = constructor.newInstance();
                            break;
                        } else if (constructor.getParameterTypes()[0].equals(DatabaseMapper.class)) {
                            instance = constructor.newInstance(databaseMapper);
                            break;
                        }
                    }

                    handlerMap.put(httpMapping, instance);
                }
            }
        }

        return new DispatcherHandler(handlerMap);
    }
}

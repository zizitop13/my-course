package com.zizitop.course.se.controller;

import com.zizitop.course.se.controller.house.RequestMapping;
import com.zizitop.course.se.utils.PackageScanner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DispatcherHandlerFactory {

    public DispatcherHandler create(String packageForScan){
        try {
            return createDispatcherHandler(packageForScan);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private DispatcherHandler createDispatcherHandler(String packageForScan) throws InvocationTargetException, InstantiationException, IllegalAccessException {

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
                        }
                    }

                    handlerMap.put(httpMapping, instance);
                }
            }
        }

        return new DispatcherHandler(handlerMap);
    }
}

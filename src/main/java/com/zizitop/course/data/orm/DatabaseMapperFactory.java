package com.zizitop.course.data.orm;

import com.zizitop.course.utils.PackageScanner;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseMapperFactory {


    private final DatabaseMapperSettings settings;

    public DatabaseMapperFactory(DatabaseMapperSettings settings) {
        this.settings = settings;
    }

    public DatabaseMapper createDatabaseMapper(){
        List<Class<?>> classes = PackageScanner.scanPackage(settings.entitiesPackage);
        Map<Class<?>, Converter> converters = new HashMap<>();

        for(Class<?> cl : classes){
            Annotation[] declaredAnnotations = cl.getDeclaredAnnotations();
            for(Annotation annotation : declaredAnnotations){
                if(annotation instanceof ValueObject){
                    ValueObject valueObject  = (ValueObject) annotation;
                    Class<? extends Converter> converterClass = valueObject.converter();
                    try {
                        Constructor<? extends Converter> declaredConstructor = converterClass.getDeclaredConstructor();
                        Converter converter = declaredConstructor.newInstance();
                        converters.put(cl, converter);
                    } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                             IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        return new DatabaseMapperImpl(converters);
    }
}

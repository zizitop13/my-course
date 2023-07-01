package com.zizitop.course.se.data.orm;

import com.zizitop.course.se.data.OneToOne;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class DatabaseMapperImpl implements DatabaseMapper {

    private final Map<Class<?>, Converter> converters;

    DatabaseMapperImpl(Map<Class<?>, Converter> converters) {
        this.converters = converters;
    }

    @Override
    public <T> T map(ResultSet resultSet, Class<T> tClass) {
        try {
            Constructor<T> constructor = tClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            T instance = constructor.newInstance();

            Field[] declaredFields = tClass.getDeclaredFields();
            for (Field field : declaredFields) {

                Annotation oneToOne = field.getDeclaredAnnotation(OneToOne.class);

                if(oneToOne != null){
                    continue;
                }

                String label = field.getName(); //TODO: transform from snake case


                Class<?> type = field.getType();

                Converter converter = converters.get(type);

                if(converter != null){
                    type = converter.getSourceType();
                }
                Object result = resultSet.getObject(label, type);
                if(converter != null){
                    result = converter.convert(result);
                }
                field.setAccessible(true);
                field.set(instance, result);
            }

            return instance;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

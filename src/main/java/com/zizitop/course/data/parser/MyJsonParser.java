package com.zizitop.course.data.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyJsonParser implements JsonParser{

    private String payload;
    @Override
    public <T> T parse(String payload, Class<T> clazz) throws IOException, NoSuchFieldException, IllegalAccessException {
        StringBuilder jsonStringBuilder = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(payload))) {
            int c;
            while ((c = fileReader.read()) != -1) {
                jsonStringBuilder.append((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsonString = jsonStringBuilder.toString();
        System.out.println(jsonString);


        StringBuilder builder = new StringBuilder();
        for (int i = 3; i < jsonString.length()-3; i++) {
            char c = jsonString.charAt(i);
            if (Character.isLetterOrDigit(c) || Character.toString(c).equals(":") || Character.toString(c).equals("\n")) {
                builder.append(c);
            }
        }
        String newJsonString = builder.toString();

        Scanner sc = new Scanner(newJsonString);
        Map<String, String> map = new HashMap<>();
        while(sc.hasNextLine()) {
            String[] parts = sc.nextLine().split(":");
            map.put(parts[0], parts[1]);
        }

        // Заполнение полей объекта значениями из HashMap
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String fieldName = entry.getKey();
            String fieldValue = entry.getValue();

            Field field = Class.class.getDeclaredField(fieldName);
            field.setAccessible(true);

            field.set(clazz, fieldValue);

        }

        T obj = (T) clazz;

        return obj;

    }
}

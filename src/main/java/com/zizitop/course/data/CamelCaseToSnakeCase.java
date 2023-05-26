package com.zizitop.course.data;

import java.util.LinkedList;
import java.util.ListIterator;

import static java.lang.Character.toUpperCase;

public class CamelCaseToSnakeCase {
    public static String convert(String snakeCase) {
        char[] snake = snakeCase.toCharArray();
        LinkedList<Character> camel = new LinkedList<>();

        for (int i = 0; i < snake.length; i++) {
            camel.add(snake[i]);
        }

        for (int i = 0; i < camel.size(); i++) {


            if (camel.get(i) == '_') {
                camel.remove(i);
                if (i < camel.size()) {
                    Character nextChar = toUpperCase(camel.get(i));
                    camel.set(i, nextChar);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Character c : camel) {
                sb.append(c);
            }

            String result = sb.toString();

            return result;

        }

}

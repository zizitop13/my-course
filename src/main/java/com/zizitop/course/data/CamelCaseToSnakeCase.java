package com.zizitop.course.data;

public class CamelCaseToSnakeCase {
    public static String convert(String camelCase) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < camelCase.length(); i++) {
            char currentChar = camelCase.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                stringBuilder.append("_");
            }
            stringBuilder.append(Character.toLowerCase(currentChar));
        }
        return stringBuilder.toString();
    }
}

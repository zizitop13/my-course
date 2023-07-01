package com.zizitop.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SpringBootMain {

    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        List<?> list = new ArrayList<Number>();

        int i = new Integer(0);


        map.put("te", new Double(0.0));
        map.put("te", 3.14);
        SpringApplication.run(SpringBootMain.class, args);
    }

}

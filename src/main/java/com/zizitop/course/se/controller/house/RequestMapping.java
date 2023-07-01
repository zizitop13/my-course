package com.zizitop.course.se.controller.house;

import com.zizitop.course.se.controller.METHOD;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    METHOD method();

    String path();
}

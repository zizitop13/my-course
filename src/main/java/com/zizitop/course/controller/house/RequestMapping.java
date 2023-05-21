package com.zizitop.course.controller.house;

import com.zizitop.course.controller.METHOD;

public @interface RequestMapping {
    METHOD method();

    String path();
}

package com.zizitop.course.controller;

import java.util.Map;

public interface ControllerHandler {
    Object execute(Object body, Map<String,String> params, Map<String,String> headers);
}

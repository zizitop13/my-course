package com.zizitop.course.data.controller;

import java.util.Map;

public interface HttpController {
    Object execute(Object body, Map<String,Object> params, Map<String,Object> headers);
}

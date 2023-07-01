package com.zizitop.course.se.data.orm;

import java.sql.ResultSet;

public interface DatabaseMapper {
    <T> T map(ResultSet resultSet, Class<T> tClass);
}

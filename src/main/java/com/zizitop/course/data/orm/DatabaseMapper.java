package com.zizitop.course.data.orm;

import java.sql.ResultSet;

public interface DatabaseMapper {
    <T> T map(ResultSet resultSet, Class<T> tClass);
}

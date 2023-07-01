package com.zizitop.course.spring.config;

import com.zizitop.course.se.controller.DispatcherHandler;
import com.zizitop.course.se.controller.DispatcherHandlerFactory;
import com.zizitop.course.se.data.orm.DatabaseMapper;
import com.zizitop.course.se.data.orm.DatabaseMapperFactory;
import com.zizitop.course.se.data.orm.DatabaseMapperSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public DatabaseMapper databaseMapper(){
        DatabaseMapperSettings settings = new DatabaseMapperSettings();
        settings.entitiesPackage = "com.zizitop.course.se.data.model";
        DatabaseMapperFactory databaseMapperFactory = new DatabaseMapperFactory(settings);
        return databaseMapperFactory.createDatabaseMapper();
    }

    @Bean
    public DispatcherHandler dispatcherHandler(){
        DispatcherHandlerFactory dispatcherHandlerFactory = new DispatcherHandlerFactory();
        return dispatcherHandlerFactory.create("com.zizitop.course.se.controller.house");
    }


}

package com.zizitop.course.config;

import com.zizitop.course.controller.DispatcherHandler;
import com.zizitop.course.controller.DispatcherHandlerFactory;
import com.zizitop.course.data.orm.DatabaseMapper;
import com.zizitop.course.data.orm.DatabaseMapperFactory;
import com.zizitop.course.data.orm.DatabaseMapperSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public DatabaseMapper databaseMapper(){
        DatabaseMapperSettings settings = new DatabaseMapperSettings();
        settings.entitiesPackage = "com.zizitop.course.data.model";
        DatabaseMapperFactory databaseMapperFactory = new DatabaseMapperFactory(settings);
        return databaseMapperFactory.createDatabaseMapper();
    }

    @Bean
    public DispatcherHandler dispatcherHandler(){
        DispatcherHandlerFactory dispatcherHandlerFactory = new DispatcherHandlerFactory();
        return dispatcherHandlerFactory.create("com.zizitop.course.controller.house");
    }


}

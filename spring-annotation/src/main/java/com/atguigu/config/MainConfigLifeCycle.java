package com.atguigu.config;

import com.atguigu.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@ComponentScan("com.atguigu.bean")
@Configuration
public class MainConfigLifeCycle {
//    @Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car(){
        return new Car();
    }
}

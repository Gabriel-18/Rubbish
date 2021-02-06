package com.atguigu.config;

import com.atguigu.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(value = "com.atguigu",useDefaultFilters = false,includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}
//        ),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class})
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = MyTypeFilter.class)
})
public class MainConfig {
    @Bean(value = "sb")
    public Person person() {
        return new Person("lisi", 20);
    }
}

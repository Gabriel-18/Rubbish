package com.atguigu;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args) {
//        ApplicationContext applicationContext =
//                new ClassPathXmlApplicationContext("beans.xml");
//        Person person = (Person) applicationContext.getBean("person");
//        System.out.println(person);

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);
//                Person person = (Person) applicationContext.getBean("person");
//                System.out.println(person);
        String[] type = applicationContext.getBeanNamesForType(Person.class);
        for (String s : type) {
            System.out.println(s);
        }
    }
}

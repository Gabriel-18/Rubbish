package com.atguigu.test;

import com.atguigu.bean.Person;
import com.atguigu.config.MainConfig;
import com.atguigu.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest {
    AnnotationConfigApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(MainConfig2.class);
    @Test
    public void testImport() {
        printBeans(applicationContext);
        Object colorFactoryBean = applicationContext.getBean("colorFactoryBean");
        System.out.println(colorFactoryBean.getClass());
    }
    private void printBeans(AnnotationConfigApplicationContext applicationContext) {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
    @Test
    public void test03() {

        // Return the names of all beans defined in this registry.
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);

        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        Map<String, Person> beansOfType = applicationContext.getBeansOfType(Person.class);
        for (String s : beansOfType.keySet()) {
            System.out.println(s );
        }
    }
    @Test
    public void test02() {

        // Return the names of all beans defined in this registry.
//        String[] definitionNames = applicationContext.getBeanDefinitionNames();
//        for (String definitionName : definitionNames) {
//            System.out.println(definitionName);
//        }
//
        System.out.println("容器创建成功");
//        Object person = applicationContext.getBean("person");
////        Object person2 = applicationContext.getBean("person");
//        System.out.println(person == person2);
    }

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);
        // Return the names of all beans defined in this registry.
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            System.out.println(definitionName);
        }
    }
}

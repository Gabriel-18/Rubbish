package com.atguigu.test;

import com.atguigu.config.MainConfigLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_LifeCycle {
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfigLifeCycle.class);
        System.out.println("容器创建完成。。。。");
        applicationContext.close();
    }
}

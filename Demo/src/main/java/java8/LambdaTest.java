package java8;


import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class LambdaTest {

    @Test
    public void testClosure() throws InterruptedException {
        /* 在匿名内部类的外面定义一个String变量 */
        final String str = "hello";
        // 构造一个匿名内部类对象
        // 产生了两个class文件
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(str);
//                System.out.println("this============>" + this);
//            }
//        };
        // 产生了一个class文件
        Runnable r = () -> {
                System.out.println(str);
                System.out.println("this============>" + this);
        };

        new Thread(r).start();
        TimeUnit.SECONDS.sleep(1);
    }

}
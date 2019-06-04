package Lambda.demo1;

public class Demo02Lambda {
    public static void main(String[] args) {

        //使用匿名内部类的方式实现多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "新线程创建");

            }
        }).start();

        //使用lambda表达式方式实现多线程

        new Thread(()->
             {
                System.out.println(Thread.currentThread().getName() + "新线程创建");

            }).start();

        //使用lambda表达式方式实现多线程
        new Thread(()-> System.out.println(Thread.currentThread().getName() + "新线程创建")).start();

    }
}

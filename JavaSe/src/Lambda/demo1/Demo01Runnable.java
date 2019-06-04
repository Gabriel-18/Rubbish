package Lambda.demo1;

public class Demo01Runnable {
    public static void main(String[] args) {
        Runnable run = new RunnableImpl();
        Thread t = new Thread(run);
        t.start();

        //简化代码
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "新线程创建");

            }
        };
        new Thread(runnable).start();

        //简化代码
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "新线程创建");

            }
        }).start();
    }
}

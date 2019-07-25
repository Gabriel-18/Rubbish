public class SingletonDemo {
    private static SingletonDemo instance = null;

    public SingletonDemo() {
        System.out.println(Thread.currentThread().getName()+"\t 我是构造方法singletonDemo()");
    }

    // 加上synchronized能解决问题但是太重了
    //public static synchronized SingletonDemo getInstance() {
    //    if (instance == null) {
    //        instance = new SingletonDemo();
    //    }
    //    return instance;
    //}


    //DCL (Double Check  Lock 双端检锁机制)
    //但是在多线程环境下会导致一个线程获得还没有初始化的实例
    // 必须加上volatile 禁止指令重排
    //uniqueInstance 采用 volatile 关键字修饰也是很有必要的， uniqueInstance = new Singleton(); 这段代码其实是分为三步执行：
    //为 uniqueInstance 分配内存空间
    //初始化 uniqueInstance
    //将 uniqueInstance 指向分配的内存地址
    public static synchronized SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        // 单线程（main线程的操作）
        //System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        //System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        //System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        //
        //
        //System.out.println();
        //System.out.println();
        //System.out.println();

        //并发多线程后，情况发生了很大的变化
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}

package Singleton;

/**
 * Ⅰ 懒汉式-线程不安全
 */
public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton() {
    }

    /**
     * 多线程环境下不安全`
     * 多个线程同时进入if(......)
     * 则返回多个实例
     * @return
     */
    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}

package Singleton;

/**
 * Ⅱ 饿汉式-线程安全
 * 但是直接实例化的方式也丢失了延迟实例化带来的节约资源的好处
 */
public class Singleton1 {
    private static Singleton1 uniqueInstance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getUniqueInstance() {
        return uniqueInstance;
    }
}

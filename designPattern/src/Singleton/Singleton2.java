package Singleton;

public class Singleton2 {
    private static Singleton2 unqueInstance;

    private Singleton2() {
    }

    /**
     * 加锁
     * 其他线程需要等待,性能下降
     * 不推荐使用
     * @return
     */
    public static synchronized Singleton2 getUnqueInstance() {
        if (unqueInstance == null) {
            unqueInstance = new Singleton2();
        }
        return unqueInstance;
    }
}

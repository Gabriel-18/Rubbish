package Singleton;

/**
 * Ⅳ 双重校验锁-线程安全
 */
public class Singleton3 {
    /**
     * volatile 可以禁止 JVM 的指令重排
     */

    private volatile static Singleton3 uniqueInsatance;

    private Singleton3() {}

    /**
     *双重校验锁先判断 uniqueInstance 是否已经被实例化，
     * 如果没有被实例化，那么才对实例化语句进行加锁。
     * @return
     */
    public static Singleton3 getUniqueInsatance() {
        if (uniqueInsatance == null) {
            // 防止多个进程进来,然后只是新后问题,多次实例化
            synchronized (Singleton3.class) {
                if (uniqueInsatance == null) {
                    uniqueInsatance = new Singleton3();
                }
            }
        }
        return uniqueInsatance;
    }
}

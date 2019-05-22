package Singleton;

/**
 * 当调用getUniqueInstance()时才会触发SingletonHolder.SINGLETON
 * 此时singletonHoler才会被加载,初始化INSTANCE实例,并且保证INSTANCE只被初始一次
 */
public class Singleton4 {
    private Singleton4() {

    }

    private static class SingletonHolder {
        private static final Singleton4 SINGLETON = new Singleton4();
    }

    public static Singleton4 getUniqueInstance() {
        return SingletonHolder.SINGLETON;
    }
}

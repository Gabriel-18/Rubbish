import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData {
    //volatile int number = 0;
    int number = 0;

    public void addTO60() {
        this.number = 60;
    }
    // 请注意，此时number前面加volatile关键字修饰的，volatile不保证原子性
    public void addPlusPlus() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAutomic() {
        atomicInteger.getAndIncrement();
    }
}

/**
 * 1 验证voltile的可见性
 *      1.1 假如 int  number  = 0;  number 变量之前根本没有添加volatile关键字修饰，没有可见性
 *      1.2  添加volatile，可以解决可见性问题
 *
 *  2 验证volatile不保证原子性
 *      2.1 原子性指的是什么意思？
 *          不可分割，完整性，也即是某个线程正在做某个具体业务时，中间不可以被加塞或者被分割。
 *          需要整体完成，要么同时成功，要么同时失败。
 *
 *      2.2 volatile不保证原子性的案例演示
 *
 *      2.3 why
 *
 *      2.4 如何解决原子性
 *       * 加sync
 *  *   * 使用juc下的AtomicInteget
 */
public class VolatileDemo {
    public static void main(String[] args) {
        //seeOKByVoltile();
        MyData myData1 = new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData1.addPlusPlus();
                    myData1.addAutomic();
                }
            }, String.valueOf(i)).start();
        }
        // 需要等待上面20个线程都全部计算完成后，再用main线程取得最终的结果值看是多少？
        // java后台默认两个线程main 和 gc
        while (Thread.activeCount() > 2) {
            // 礼让
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t int type. finally number value: " + myData1.number);
        System.out.println(Thread.currentThread().getName() + "\t  atomicInteger type,finally number value: " + myData1.atomicInteger);
    }

    // volatile可以保证可见性， 及时通知其他线程，主物理内存的值已经别修改
    private static void seeOKByVoltile () {
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");

            // pause for some time
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myData.addTO60();
            ;
            System.out.println(Thread.currentThread().getName() + "\t   updated number value" + myData.number);

        }).start();

        // main
        while (myData.number == 0) {
            // wait until number is no more 0
        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }
}
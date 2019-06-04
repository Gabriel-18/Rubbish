package os;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

class MutiThread implements Runnable{
    private CountDownLatch count;
    private CyclicBarrier barrier;
    public int n;
    public MutiThread (CountDownLatch count,CyclicBarrier barrier,int n) {
        this.count = count;
        this.barrier = barrier;
        this.n = n;
    }

    Object lock = new Object();
    public class Has{
        int i = 1;
        public boolean hasNumber() {
            return i <= n;
        }
        public int getNumber() {
            return i;
        }
        public void inc() {
            i++;
        }
    }
    Has has= new Has();
    @Override
    public void run() {
        int sum = 0;

        synchronized (has) {
            while(has.hasNumber()) {
                sum = 0;
                for(int j = 1;j < has.getNumber();j++ ) {
                    if( has.getNumber() % j == 0) {
                        sum += j;
                    }
                }
                if( sum == has.getNumber()) {
                    System.out.println(has.getNumber()+" is a perfect number");
                }
                else {
                    System.out.println(has.getNumber()+" is not a perfect number");
                }
                has.inc();
            }

        }
        if(has.hasNumber()) {
            run();
        }

        // when it comes to close, count --
        count.countDown();

    }
}


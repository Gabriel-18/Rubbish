package os;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {

        int n ;
        int p ;
        Scanner in = new Scanner(System.in);
        System.out.println("put the num:");
        n = in.nextInt();
        System.out.println("put the num of thread:");
        p = in.nextInt();
        final CyclicBarrier barrier = new CyclicBarrier(p);
        final CountDownLatch count = new CountDownLatch(p);

        MutiThread cT = new MutiThread(count,barrier,n);
        ExecutorService executorService = Executors.newFixedThreadPool(p);
        long start = System.currentTimeMillis();
        for(int i = 0;i < p ;i++) {
            // return the result
            executorService.submit(cT);
        }
        try {
            count.await();
            executorService.shutdown();
            long end = System.currentTimeMillis();
            System.out.print("it works:"+(end - start) + " milliseconds");
        }catch(InterruptedException e) {
            e.printStackTrace();
        }

    }

}

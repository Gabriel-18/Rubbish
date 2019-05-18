package second;

import java.util.Scanner;
public class hello {
    public static void main(String[] args) throws InterruptedException {
        int n, p, zu;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        p = in.nextInt();
        zu= n/p;
        if(n%p!=0)zu++;
        System.out.println("每个线程中数字个数：" + zu);
        for(int i=0; i< p; i++) {
            Add add = new Add(n,zu,i);
            add.start();
        }
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终sub=" + Add.sub);
        if(Add.sub == n)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
class Add extends Thread{
    static int sub;
    private int n;
    private int zu;
    private int i;
    public Add(int n, int zu, int i) {
        this.n = n;
        this.zu = zu;
        this.i = i;
    }

    public void run() {
        for(int k = i*zu + 1; k <= zu*(i+1); k ++){
            if(k >= n)break;
            if(n%k==0)sub+=k;
        }
    }
}
package concurrent.deadlock;

public class DeadLock {
    public static void main(String[] args) {
        Account a1 = new Account();
        Account a2 = new Account();
        Thread t1 = new Thread(new Transfer(a1, a2, 10));
        Thread t2 = new Thread(new Transfer(a2, a1, 10));
        t1.start();
        t2.start();
    }
}
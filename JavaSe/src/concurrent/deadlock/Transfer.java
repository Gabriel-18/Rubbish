package concurrent.deadlock;
public class Transfer implements Runnable {

    private final Account from;
    private final Account to;
    private final int amount;

    public Transfer(Account from, Account to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    //@Override
    //public void run() {
    //    synchronized (from) {
    //        synchronized (to) {
    //            from.amount = from.amount - amount;
    //            to.amount = to.amount + amount;
    //            System.out.println("success");
    //        }
    //    }
    //
    //}

    @Override
    public void run() {
        synchronized (from) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (to) {
                from.amount = from.amount - amount;
                to.amount = to.amount + amount;
                System.out.println("success");
            }
        }
    }
}


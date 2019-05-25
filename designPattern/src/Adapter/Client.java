package Adapter;

public class Client {
    public static void main(String[] args) {
        Turkey turkey = new WideTurkey();
        Duck duck = new TurkeyAdapter(turkey);
        duck.quark();
    }
}

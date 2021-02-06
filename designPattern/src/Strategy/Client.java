package Strategy;

public class Client {

    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.setQuackBehavior(new Squeak());
        duck.performQuack();
        duck.setQuackBehavior(new Quack());
        duck.performQuack();
//
//        Integer[] a = new Integer[]{1, 8, 2, 9};
//        Arrays.sort(a, (a1, b1) -> {
//            return a1 > b1;
//        });
    }
}

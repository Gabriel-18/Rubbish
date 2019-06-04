package Lambda.demo2;

public class Demo02Cook {
    public static void main(String[] args) {
        invokeCook(new Cook() {
            @Override
            public void makeFood() {
                System.out.println("吃饭了");
            }
        });

        //lambda
        invokeCook(()->{
            System.out.println("dfdf");
        });
        //lambda
        invokeCook(()-> System.out.println("dfdf"));
    }
    private static void invokeCook(Cook cook) {
        cook.makeFood();
    }
}

package Lambda.demo4;

public class Demo04Calculator {
    public static void main(String[] args) {
        invokeCal(120,130,(int a, int b)->{
            return a + b;
        });
        invokeCal(120,130,(a, b)->
             a + b
        );
    }
    private static void invokeCal(int a, int b,Calculator c) {
        int result = c.cal(a, b);
        System.out.println(result);
    }
}

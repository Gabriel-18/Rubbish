import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n ;
        while (true) {
            n = scanner.nextInt();
            if (n == 0) {
                System.out.println("programe is over.");
                break;
            } else if (isprime(n)) {
                System.out.println(String.format(n+ " is sushu."));
            } else {
                System.out.println(String.format(n+ " is not sushu."));
            }

        }

    }
    public static boolean isprime(int n) {
        int i;
        if(n <= 1) {
            return false;
        }
        for(i = 2;i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

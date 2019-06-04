import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        System.out.println("Please input 10 numbers:");
        Scanner scanner = new Scanner(System.in);
        int a;
        int[] b = new int[10];
        System.out.println("Your numbers are:");

        for (int i = 0; i < 10; i++) {
            b[i] = scanner.nextInt();
    }
        for (int i = 0; i < 10; i++) {
            System.out.print(b[i]+" ");
        }
        System.out.println();
        System.out.println("Please input m:");
        int m = scanner.nextInt();
        System.out.println("The new numbers are:");
        for (int i = b.length - m; i < 10; i++) {
            System.out.print(b[i]+" ");
        }
        for (int i = 0; i < b.length - m; i++) {
            System.out.print(b[i]+" ");
        }



    }
}

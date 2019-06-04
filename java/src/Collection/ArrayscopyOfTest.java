package Collection;

import java.util.Arrays;

public class ArrayscopyOfTest {

    public static void main(String[] args) {
        int[] a = new int[3];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        int[] b = Arrays.copyOf(a, 20);
        System.out.println("b.length"+b.length);
    }
}
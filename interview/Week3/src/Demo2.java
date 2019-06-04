import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String s1 = s.toLowerCase();
        int[] a = countLetters(s1);
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                System.out.println(String.format("(%c)Num=%d",i+'A',a[i]));
            }
        }

    }
    private static int[] countLetters(String s) {
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (index >= 0 && index <= 25) {
                a[index] = a[index] + 1;
            }

        }
        return a;
    }
}

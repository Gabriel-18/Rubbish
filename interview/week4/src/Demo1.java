import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        System.out.println("Please input a sentence:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String s1 = s.toUpperCase();
        char a = '0';
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        for (int i = 0; i < s1.length(); i++) {
            a = s1.charAt(i);
            if (a >= 'A' && a <= 'Z') {
                count1 ++;
            } else if (a >= '0' && a <= '9') {
                count2 ++;
            } else if (a == ' ') {
                count3 ++;
            } else {
                count4 ++;
            }
        }
        System.out.printf("The number of numbers is: %d\n" +
                "The number of English letters is: %d \n" +
                "The number of blank space is: %d \n" +
                "The number of other characters is: %d",count2, count1, count3,count4);

    }
}

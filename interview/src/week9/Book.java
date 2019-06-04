package week9;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Book implements Comparable<Book>{

    private String name;
    private String price;

    public Book(String name, String price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Book o) {
        return Integer.valueOf(this.price) -Integer.valueOf(o.price);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Book> list = new LinkedList<>();
        String[] s = new String[2];
        String name = null;
        System.out.println("input several Book,in the end #");
        while (true) {
            name = in.nextLine().trim();

            if (name.equals("#")) {
                break;
            } else {
                s = name.split(",");
                list.add(new Book(s[0],s[1]));
            }

        }
        System.out.println("input a new Book:");
        name = in.nextLine();
        s = name.split(",");
        Book b = new Book(s[0],s[1]);
        System.out.println("new book:<" + s[0] + ">as same books");
        for (Book book : list) {
            int cmp = b.compareTo(book);
            if (cmp == 0) {
                System.out.println(book.name +","+ Double.valueOf(b.price));
            }
        }
    }
}

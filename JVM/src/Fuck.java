public class Fuck {
    public static void main(String[] args) {
        String s = new String("abc");
        String s1 = new String("abc");
        String s2 = s1.intern();
        String s3 = "abc";
        String s4 = "abc";
        System.out.println(s == s1);
        System.out.println(s1 == s2);
        System.out.println(s3 == s2);
        System.out.println(s3 == s4);
    }
}

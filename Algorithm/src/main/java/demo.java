public class demo {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3  = "he" + "llo";
        String s4  = "he" + new String("llo");
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
    }
}

package leetcode;

public class RuntimeConstant {
    public static void main(String args[]){
        String s = "java";
        String str1 = new StringBuilder("ja").append("va").toString();
        System.out.println(str1.intern() == s);

        String str2 = new StringBuilder("Ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
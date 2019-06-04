package operators.test;// operators/MinMax.java
// TIJ4 Chapter Operators, Exercise 9, page 111
// Display the largest and smallest numbers for both float and double
// exponential notation.

public class MinMax {
    public static void main(String[] args) {
        double max = Double.MAX_VALUE;
        System.out.println("Max double = " + max);
        double min = Double.MIN_VALUE;
        System.out.println("Min double = " + min);
        float maxf = Float.MAX_VALUE;
        System.out.println("Max float = " + maxf);
        float minf = Float.MIN_VALUE;
        System.out.println("Min float = " + minf);
    }
}
package lab5;

import java.util.Scanner;

public class P4T2 {
    public  static  void  main(String[]  args)  {

        Circle  c  =  new  Circle();

        Scanner s  =  new  Scanner(System.in);
        System.out.println("Please  input  r:  ");
        float  r  =  s.nextFloat();

        System.out.println("The  area  is  :  "+  c.getArea(r));
        System.out.println("The  circumference  is  :  "+c.getCircumference(r));
    }
}

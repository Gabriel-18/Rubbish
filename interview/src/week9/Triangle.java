package week9;

import java.util.Scanner;

public  class  Triangle  {
    private  double  a,  b,  c;

    public Triangle(double a, double b, double c) {
        if (a + b > c && b + c > a && a + c > b) {
            this.a = a;
            this.b = b;
            this.c = c;

        } else {
            this.a = 0;
            this.b = 0;
            this.c = 0;
        }

    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        if (a + b <= c || b + c <= a || a + c <= b) {
            System.out.println("a input error");
        }else if (a + b > c && b + c > a && a + c > b) {
            this.a = a;
        }
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
       if (a + b <= c || b + c <= a || a + c <= b)  {
            System.out.println("b input error");
        } else if (a + b > c && b + c > a && a + c > b)  {
            this.b = b;
        }
    }

    public double getC() {

        return c;
    }

    public void setC(double c) {
        if (a + b <= c || b + c <= a || a + c <= b)  {
            System.out.println("c input error");
        } else if (a + b > c && b + c > a && a + c > b) {
            this.c = c;
        }
    }

    public  static  void  main(String  args[])  {
        Scanner in  =  new  Scanner(System.in);
        double  x  =  in.nextDouble();
        double  y  =  in.nextDouble();
        double  z  =  in.nextDouble();
        Triangle  t  =  new  Triangle(x,  y,  z);
        System.out.println("perimeter="  +  t.getPerimeter());
        System.out.println("area="  +  t.getArea());
        System.out.println(t);
        t.setSide(t.getA()  +  3,  t.getB()  +  2,  t.getC()  +  1);
        System.out.println(t);
        t.setA(t.getA()  +  20);
        System.out.println(t);
        t.setB(t.getB()  +  20);
        System.out.println(t);
        t.setC(t.getC()  +  20);
        System.out.println(t);
        in.close();
    }

    private void setSide(double v, double v1, double v2) {
        setA(v);
        setB(v1);
        setC(v2);
    }

    private double getArea() {
        double p = 0.5 * getPerimeter();
        return Math.sqrt(p* (p-a) * (p - b) * (p - c));
    }

    private double getPerimeter() {
        return a + b + c;
    }

    @Override
    public String toString() {
        return
                "a=" + a +
                ",b=" + b +
                ",c=" + c;
    }
}
import java.util.Scanner;

public class Triangle {
    private double a, b, c;
    //方法有：
    double getPerimeter() {
        return a + b + c;
    }//，计算三角形的周长
    double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));

    }//，计算三角形的面积
    public void setSide(double x, double y, double z) {
        this.a = x;
        this.b = y;
        this.c = z;
    }//，对属性a、b、c分别赋值为x、y、z
    //另外，有构造方法：
    public Triangle(double a, double b, double c) {
        if (a + b <= c) {
            a = b = c =0;
        } else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }//，如果a、b、c不能构成一个三角形，则a、b、c都赋值为0

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();

        Triangle triangle = new Triangle(a, b, c);
        System.out.println("perimeter="+triangle.getPerimeter());
        System.out.println("area="+triangle.getArea());
        System.out.println("a="+triangle.a+",b="+triangle.b+",c="+triangle.c);

    }
}

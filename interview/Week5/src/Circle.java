import java.util.Scanner;

public class Circle {
    private double radius;
    double getPerimeter(){
        return Math.PI * radius * 2;
    }
    double getArea(){
        return Math.PI * radius * radius;
    }
    void disp(){
        System.out.println("radius="+radius);
        System.out.println("perimeter="+getPerimeter());
        System.out.println("area="+getArea());
    }
    Circle(){
        radius = 0;
    }
    Circle(double r){
        radius = r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n = in.nextDouble();
        Circle circle = new Circle(n);
        circle.disp();
    }
}

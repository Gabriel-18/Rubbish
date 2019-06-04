
import java.util.Scanner;

public class Complex {
	double a, b;
	double c, d;
	
	public Complex(double a, double b, double c, double d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	public Complex() {}
	
	public void fun1() {
		System.out.println("ComplexNumber a: "+a+" + " +b+"i");
		System.out.println("ComplexNumber b: "+c +" + " +d+"i");
	}
	public void fun2() {
		double sum1 = a + c;
		double sum2 = d + b;
		System.out.println("(a + b) = "+ sum1+ " + "+ sum2 + "i");
	}	
	public void fun3() {
		double sum1 = a - c;
		double sum2 = b - d;
		System.out.println("(a - b) = "+ sum1+ " + "+ sum2 + "i");
	}
	
	public void fun4() {
		double sum1 = a*c - b*d ;
		double sum2 = b*c + a*d;
		System.out.println("(a * b) = "+ sum1+ " + "+ sum2 + "i");
	}
	
	public static void main(String[] a) {
		Scanner in = new Scanner(System.in);
		System.out.println("input c1:");
		double n1 = in.nextDouble();
		double n2 = in.nextDouble();
		System.out.println("input c2:");
		double n3 = in.nextDouble();
		double n4 = in.nextDouble();
		Complex b = new Complex(n1,n2,n3,n4);
		b.fun1();
		b.fun2();
		b.fun3();
		b.fun4();
	}
}


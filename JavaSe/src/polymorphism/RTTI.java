package polymorphism;
//: polymorphism/RTTI.java
// Downcasting & Runtime type information (RTTI).
// {ThrowsException}

class Useful {
    public void f() {
        System.out.println(1);
    }
    public void g() {
        System.out.println(2);
    }
}

class MoreUseful extends Useful {
    public void f() {
        System.out.println(11);
    }
    public void g() {
        System.out.println(22);
    }
    public void u() {
        System.out.println(3);
    }
    public void v() {}
    public void w() {}
}

public class RTTI {
    public static void main(String[] args) {
        Useful[] x = {
                new Useful(),
                new MoreUseful()
        };
        x[0].f();
        x[1].g();
        // Compile time: method not found in Useful:
        //! x[1].u();
        //本来就是这个类型 所以没问题
        ((MoreUseful)x[1]).u(); // Downcast/RTTI
        // 超过本来能成为的类型
        //((MoreUseful)x[0]).u(); // Exception thrown
    }
} ///:~

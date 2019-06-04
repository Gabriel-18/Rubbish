package reusing;

// reusing/Frog.java
// TIJ4, Chapter Reusing, Exercise 16, page 262
/* Create a class called Amphibian. From this, inherit a class called Frog.
 * Put appropriate methods in the base class. In main(), create a Frog and upcast
 * it to Amphibian, and demonstrate that all the methods still work.
 */
class Amphibian {
    protected void swim() {
        System.out.println("Amphibian swim");
    }
    protected void speak() {
        System.out.println("Amphibian speak");
    }
    void eat() {
        System.out.println("Amphibian eat");
    }
    static void grow(Amphibian a) {
        System.out.println("Amphibian grow");
        a.eat();
    }
}

public class Frog extends Amphibian {
    public static void main(String[] args) {
        Frog f = new Frog();
        // call base-class methods:
        f.swim();
        f.speak();
        f.eat();
        // upcast Frog to Amphibian argument:
        Amphibian.grow(f);
    }
}
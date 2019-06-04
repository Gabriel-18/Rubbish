package polymorphism;

// polymorphism/Sandwich11.java
// TIJ4 Chapter Polymorphism, Exercise 11, page 295
// Add class Pickle to Sandwich.java

class Meal {
    
    Meal() { System.out.println("Meal()"); }
}

class Bread {
    Bread() { System.out.println("Bread()"); }
}

class Cheese {
    Cheese() { System.out.println("Cheese()"); }
}

class Lettuce {
    Lettuce() { System.out.println("Lettuce()"); }
}

class Pickle {
    Pickle() { System.out.println("Pickle()"); }
}

class Lunch extends Meal {
    Lunch() { System.out.println("Lunch()"); }
}

class PortableLunch extends Lunch {
    PortableLunch() { System.out.println("PortableLunch()"); }
}

public class Sandwich11 extends PortableLunch {
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Pickle p = new Pickle();
    private Lunch l = new Lunch();
    public Sandwich11() { System.out.println("Sandwich()"); }
    public static void main(String[] args) {
        new Sandwich11();
    }
}
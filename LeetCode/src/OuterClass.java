public class OuterClass {

    class InnerClass {

    }

    private int i;
    private static int j;
    private void fuck() { }
    private static void fuck1() { }
    static class StaticInnerClass {
    }

    public static void main(String[] args) {
//         InnerClass innerClass = new InnerClass();
         // 'OuterClass.this' cannot be referenced from a static context
        OuterClass outerClass = new OuterClass();
        outerClass.fuck();
//        outerClass.j;
        InnerClass innerClass = outerClass.new InnerClass();

//        innerClass.;
        StaticInnerClass staticInnerClass = new StaticInnerClass();

    }
}
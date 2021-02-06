package Annotation.MyJunit;

public class EmployeeDAOTest {
    @MyBefore
    public void init() {
        System.out.println("init...........");
    }

    @MyAfter
    public void destroy() {
        System.out.println("destroy......");
    }

    @MyTest
    public void testSave() {
        System.out.println("save........");
    }

    @MyTest
    public void testDelete() {
        System.out.println("delete....");
    }

}

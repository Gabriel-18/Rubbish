package Annotation.MyJunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MyJunitFrameWork {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = EmployeeDAOTest.class;
        Object obj = clazz.newInstance();

        Method[] methods = clazz.getMethods();

        List<Method> mybeforeList = new ArrayList<>();
        List<Method> myAfterList = new ArrayList<>();
        List<Method> myTestList = new ArrayList<>();

        for (Method method : methods) {
            // Returns true if an annotation for the specified type
            if (method.isAnnotationPresent(MyBefore.class)) {
                mybeforeList.add(method);
            } else if (method.isAnnotationPresent(MyTest.class)) {
                myTestList.add(method);
            } else if (method.isAnnotationPresent(MyAfter.class)) {
                myAfterList.add(method);
            }
        }

        for (Method testMethod : myTestList) {
            for (Method beforeMethod : mybeforeList) {
                beforeMethod.invoke(obj);
            }
            System.out.println("================================================");
            testMethod.invoke(obj);
            System.out.println("================================================");
            for (Method afterMethod : myAfterList) {
                afterMethod.invoke(obj);
            }
        }
    }
}

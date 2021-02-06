package Annotation;

import java.lang.reflect.Type;

public class Test {
	public static void main(String[] args) {
		new B();
	}
}

class A<T>{
	public A(){

		// Returns the runtime class of this {@code Object}.
		Class clazz = this.getClass();
		//得到父类（参数化类型）,这一步相当于拿到：A<String>，父类及泛型
		// the superclass of the class represented by this object
		Type genericSuperclass = clazz.getGenericSuperclass();
		System.out.println(genericSuperclass);
		System.out.println(genericSuperclass.getClass());
		System.out.println(clazz.getName());
	}
}

class B extends A<String>{

}






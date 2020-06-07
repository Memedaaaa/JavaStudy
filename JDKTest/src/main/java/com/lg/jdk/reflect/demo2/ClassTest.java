package com.lg.jdk.reflect.demo2;

public class ClassTest {

	public static void main(String[] args) throws ClassNotFoundException {		
		
		String s1 = "abc";
		Class c1 = s1.getClass();
		//类型标识
		System.out.println(c1.getName());

		System.out.println(c1.getClasses());
		System.out.println(c1.getDeclaredClasses());
		System.out.println(c1.getSuperclass());
		System.out.println(c1.getMethods());
		System.out.println(c1.getModifiers());
		System.out.println(c1.getAnnotations());
		System.out.println(c1.getFields());
		System.out.println(c1.getDeclaredFields());
		System.out.println(c1.getConstructors());
		System.out.println(c1.getDeclaredConstructors());
		System.out.println(c1.getMethods());
		System.out.println(c1.getDeclaredMethods());

		Class c2 = Class.forName("java.lang.String");
		System.out.println(c2.getName());
		
		Class c3 = String.class;
		System.out.println(c3.getName());	

	}

}

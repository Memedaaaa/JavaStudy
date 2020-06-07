package com.lg.jdk.reflect.demo1;

public class B implements Cloneable {
	public void hello()
	{
		System.out.println("hello from B");
	}
	
	protected Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}

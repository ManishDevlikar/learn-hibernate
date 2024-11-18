package com.core;

public class A {
    private  static	A a=new A();
	private A() {
		System.out.println("hii from a");
	}
	
	public static A getA() {
		return a;
	}
}

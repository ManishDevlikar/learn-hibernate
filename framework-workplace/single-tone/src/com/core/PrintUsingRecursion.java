package com.core;

public class PrintUsingRecursion {
	static public int recursion(int num) {
		if (num <= 2500) {
			return num;
		}
		return recursion(num + 1);
	}

	public static void main(String[] args) {
		System.out.println(recursion(25));

	}
}

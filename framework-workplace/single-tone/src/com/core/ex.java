package com.core;

public class ex {
	public static void main(String[] args) {
		try {
			String str = "1234";
			int i = Integer.parseInt(str);
			System.out.println(i);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}

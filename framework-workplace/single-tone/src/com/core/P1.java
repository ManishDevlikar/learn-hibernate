package com.core;

import java.util.Scanner;

public class P1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the text");
		String str = sc.nextLine();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c != 'S' && c != 'O') {
				count++;
			}
		}
		System.out.println(count);
	}

}

// output : 
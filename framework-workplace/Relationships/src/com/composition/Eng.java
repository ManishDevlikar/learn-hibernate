package com.composition;

public class Eng {
	int eno;
	String type;
	String cc;

	public Eng(int eno, String type, String cc) {
		this.eno = eno;
		this.type = type;
		this.cc = cc;
	}

	public void getEngDetails() {
		System.out.println(this.eno + " " + this.type + " " + this.cc);

	}

}

package com.sample.test.inter;

public class C1 implements I1,I2{

	public static void main(String[] args) {
		C1 c = new C1();
		System.out.println(((I2)c).i);
	}
}

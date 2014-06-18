package com.test;

public class Person {

	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	public static void main(String[] args) {
		new Person();
		System.out.println("dandandan");
	}
}

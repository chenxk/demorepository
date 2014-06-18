package com.test;

public class Person {

	private int age;

	private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

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
	}
}

package com.test.luan;

import com.test.listener.ClickListener;

public class Person extends Per implements ClickListener{

	public Person(String name) {
		super(name);
		ClickListener a = new Person("");
		Per p = new Person("");
	}

	@Override
	public void onClick() {
	}

}

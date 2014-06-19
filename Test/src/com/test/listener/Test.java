package com.test.listener;

public class Test {

	public static void main(String[] args) {
		ClickDemo demo = new ClickDemo();
		demo.setListener(new ClickListener() {

			@Override
			public void onClick() {
				System.out.println("click");
			}
		});

		demo.setListener(new ClickListener() {

			@Override
			public void onClick() {
				System.out.println("click2222");
			}
		});

		demo.click();
	}
}

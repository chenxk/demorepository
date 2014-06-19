package com.test.listener;


public class ClickDemo {

	private ClickListener listener;

	public ClickListener getListener() {
		return listener;
	}

	public void setListener(ClickListener listener) {
		this.listener = listener;
	}

	public void click() {
		listener.onClick();
	}

	public void onClickListener(ClickListener listener) {
		this.listener = listener;
	}
	
}

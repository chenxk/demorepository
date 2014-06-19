package com.test.luan;

import java.util.List;

public class TT {

	public static void main(String[] args) {
		
		System.out.println(1024*1024*1024);
		
		StringBuffer sb = new StringBuffer("Hello ");
		System.out.println("Before change, sb = " + sb);
		sb = changeData(sb);
		System.out.println("After changeData(n), sb = " + sb);
	}

	public static StringBuffer changeData(StringBuffer strBuf) {
		StringBuffer sb2 = new StringBuffer("Hi ");
		sb2.append("World!");
		strBuf = sb2;
		return strBuf;
	}

	public static Per dd(List<Per> list) {
		return list.get(0);
	}

}

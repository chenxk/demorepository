package com.test.luan;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

public class TT {

	/**
	 * 字符串编码转换的实现方法
	 * 
	 * @param str
	 *            待转换编码的字符串
	 * @param oldCharset
	 *            原编码
	 * @param newCharset
	 *            目标编码
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String changeCharset(String str, String oldCharset, String newCharset)
			throws UnsupportedEncodingException {
		if (str != null) {
			// 用旧的字符编码解码字符串。解码可能会出现异常。
			byte[] bs = str.getBytes(oldCharset);
			// 用新的字符编码生成字符串
			return new String(bs, newCharset);
		}
		return null;
	}

	/**
	 * 字符串编码转换的实现方法
	 * 
	 * @param str
	 *            待转换编码的字符串
	 * @param newCharset
	 *            目标编码
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String changeCharset(String str, String newCharset)
			throws UnsupportedEncodingException {
		if (str != null) {
			// 用默认字符编码解码字符串。
			byte[] bs = str.getBytes();
			// 用新的字符编码生成字符串
			return new String(bs, newCharset);
		}
		return null;
	}

	public static void main(String[] args) {
		
		
		double s = 1404355492/(60*60*1000);
		
		Date date = new Date(1404358248*1000);
		System.out.println(date);
		
		System.out.println(s);

		try {
			System.out.println(new TT().changeCharset("美容", "ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*System.out.println(1024 * 1024 * 1024);

		StringBuffer sb = new StringBuffer("Hello ");
		System.out.println("Before change, sb = " + sb);
		sb = changeData(sb);
		System.out.println("After changeData(n), sb = " + sb);*/
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

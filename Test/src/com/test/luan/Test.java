package com.test.luan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;

import org.codehaus.jettison.json.JSONException;

public class Test {

	public static void main(String[] args) {

		
		String url = "http://weibo.com/u/1941767932/home?wvr=5";
		String url2 = "https://weibo.com/u/1941767932/home?wvr=5";
		
		int index = url.indexOf("//");
		System.out.println(index);
		String domain = url.substring(index + 2);
		System.out.println(domain);
		
		index = domain.indexOf("/");
		domain = domain.substring(0, index);
		System.out.println(domain);
		if(true){
			return;
		}
		
		
		
		File file2 = new File("d://sera2.txt");

		BufferedReader reader;
		long begin = System.currentTimeMillis();
		try {
			reader = new BufferedReader(new FileReader(file2));
			String tempString = null;
			// 保存上传失败的记录
			List<String> failRecord = new ArrayList<String>();
			// 记录文件有多少行
			int lineCount = 0;
			// 一次读入一行，直到读入null为文件结束
			for(int i = 0;i<5;i++){
				while ((tempString = reader.readLine()) != null) {
					failRecord.add(tempString);
					lineCount++;
					saveFile("d://sera3.txt", tempString, true);
				}
			}
			reader.close();
			long now = System.currentTimeMillis() - begin;
			System.out.println("time:" + now +  " mm	" + failRecord.size());
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (true)
			return;

		String DATETIMESTAMP_FORMAT = "yyyyMMddHHmmss";
		SimpleDateFormat format = new SimpleDateFormat(DATETIMESTAMP_FORMAT);
		String time = format.format(new Date());

		String sss = "sss_sss_sss_" + time + ".txt";

		Pattern p = Pattern.compile("_\\d{14}");
		Matcher m = p.matcher(sss);
		System.out.println(m.find());
		System.out.println(m.group());

		/*
		 * Memcache cacheClient = new Memcache(); System.out.println(5556666);
		 * String cacheKey = "AGENT_SUBGROUP_LOCK_";
		 * cacheClient.lockWaitTime(cacheKey,1000); System.out.println(555);
		 */
		/*
		 * String cacheKey = "AGENT_SUBGROUP_LOCK_"; int lockTime = 1000;
		 * Memcache memcache = new Memcache(); Thread one = new Thread(new
		 * ThreadOne(memcache, cacheKey, lockTime)); Thread two = new Thread(new
		 * ThreadTwo(memcache, cacheKey, lockTime));
		 * 
		 * one.start(); two.start();
		 */
		/*
		 * try { Thread.sleep(1000); two.start(); } catch (InterruptedException
		 * e) { e.printStackTrace(); }
		 */

		// Thread three = new Thread(new CopyOfThreadTwo());
		// three.start();

		/*
		 * HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		 * Set<Integer> keys = map.keySet();
		 * 
		 * for(int i = 1; i <= 5; i++){ int count = 0; if(keys.contains(i)){
		 * count = map.get(i); } map.put(i, ++count); }
		 * 
		 * for(int i = 1; i <= 5; i++){ int count = 0; if(keys.contains(i)){
		 * count = map.get(i); } map.put(i, ++count); }
		 * 
		 * 
		 * System.out.println(map.toString());
		 */

		File file = new File("dll/liblept168.dll");
		long K = 4921576 / 1024;
		long M = K / 1024;
		double kl = (K % 1024) / 1024.0;

		System.out.println(M + " " + kl);

		Double d = new Double(kl);
		System.out.println(String.format("%.2f", kl));
		kl = 0.5957265625;
		System.out.println(String.format("%.2f", kl));

		System.out.println(M + " " + kl);

		String ss = "com.cic.,d,#CIC#a,t,a,c,o,llec,ti#CIC#on,.,ane,w.Rpc#CIC#AgentDa#CIC#emon";
		for (String s : ss.split("#CIC#")) {
			System.out.println(s);
		}

		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 11; i++) {
			list.add("str" + i);
		}
		System.out.println(list.toString());

		List<Per> li = new ArrayList<Per>();
		for (int i = 0; i < 11; i++) {
			li.add(new Per("str" + i));
		}

		// System.out.println(li.toString());
		System.out.println("--------------");
		JSONArray json = JSONArray.fromObject(list);
		System.out.println(json.toString());

		try {
			org.codehaus.jettison.json.JSONArray json2 = new org.codehaus.jettison.json.JSONArray(
					json.toString());
			System.out.println(json2.toString());
			// json2.
			// json = (JSONArray)json2;
			// JSONArray.toArray(jsonArray, objectClass)

			JSONArray jsons = JSONArray.fromObject(json.toString());
			System.out.println(jsons.toString());
			List<String> l = (List<String>) JSONArray.toCollection(jsons,
					String.class);
			System.out.println(l.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static File saveFile(String fileName, String text ,boolean append) throws IOException {

		File f = new File(fileName);
		if (!f.exists())
		{
			f.createNewFile();
		}

		try {
			BufferedReader r = new BufferedReader(new StringReader(text));
			BufferedWriter w = new BufferedWriter(new FileWriter(f,append));
			try {
				String line = null;
				while ((line = r.readLine()) != null) {
					w.write((line));
					w.write("\n");
				}
			} finally {
				w.close();
				r.close();
			}
		} catch (IOException ex) {
			throw ex;
		}
		return f;
	}
}

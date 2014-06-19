package com.test.luan;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Set;


public class Memcache {

	private Hashtable<String, Object> hashtable = new Hashtable<String, Object>();
	
	public Memcache(){
		hashtable.put("ABC", "ABC");
	}
	public String who = "";
	
	public boolean add(String who,String name,Object value){
		
		Set<String> keys = hashtable.keySet();
		if(keys.contains(name) && keys.size() > 0){
			return false;
		}
		hashtable.put(name, value);
		
		System.out.println(who + " hashtable ：" + hashtable.keySet().toString() + "  " + System.currentTimeMillis());
		
		return true;
	}
	
	public void lockWaitTime(String who,String cacheKey,int lockTime){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, lockTime);
		Date expireTime = calendar.getTime();
		this.who = who;
		System.out.println(who + "1=================================================================" + expireTime.getTime() + "  " + System.currentTimeMillis());
		while(!add(who,cacheKey, expireTime)) {
			try {
				Thread.sleep(500);
				
				calendar = Calendar.getInstance();
				calendar.add(Calendar.SECOND, lockTime);
				expireTime = calendar.getTime();
				System.out.println(who + "2=================================================================" + expireTime.getTime() + "  " + System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void unLock(String key){
		hashtable.remove(key);
		System.out.println(this.who + "  remove " + key + "=================" + System.currentTimeMillis());
	}
	
}

package com.test.luan;
import java.util.Calendar;
import java.util.Date;

public class ThreadTwo implements Runnable {

	private Memcache memcache;

	private String cacheKey;
	private int lockTime;

	public ThreadTwo(Memcache memcache, String cacheKey, int lockTime) {
		super();
		this.memcache = memcache;
		this.cacheKey = cacheKey;
		this.lockTime = lockTime;
	}

	@Override
	public  void run() {
		boolean flag = true;
		int count = 0;
		while (flag) {
			try {
				count++;
				System.out.println("ThreadTwo 第" + count + "次请求");
				
				memcache.lockWaitTime("threadTwo",cacheKey, lockTime);
				if (count == 10) {
					flag = false;
				}
				Thread.sleep(500);
				memcache.unLock(cacheKey);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

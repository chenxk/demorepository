package com.test.luan;
import java.util.Calendar;
import java.util.Date;

public class ThreadOne implements Runnable {

	private Memcache memcache;

	private String cacheKey;
	private int lockTime;

	public ThreadOne(Memcache memcache, String cacheKey, int lockTime) {
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
				System.out.println("ThreadOne 第" + count + "次请求");
				memcache.lockWaitTime("threadOne",cacheKey, lockTime);
				if (count == 3) {
					flag = false;
				}
				Thread.sleep(5000);
				memcache.unLock(cacheKey);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

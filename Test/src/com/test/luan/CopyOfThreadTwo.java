package com.test.luan;

public class CopyOfThreadTwo implements Runnable {

	private Memcache memcache;

	private String cacheKey;
	private int lockTime;

	public CopyOfThreadTwo(){
		
	}
	
	public CopyOfThreadTwo(Memcache memcache, String cacheKey, int lockTime) {
		super();
		this.memcache = memcache;
		this.cacheKey = cacheKey;
		this.lockTime = lockTime;
	}

	@Override
	public void run() {
		System.out.println("ss");

	}

}

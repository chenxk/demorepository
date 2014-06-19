package com.test.luan;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class LuckyDraw {

	// 所有的用户
	private String userNames = "陈明真儿-1;雨霖铃;宏宏情2013;我爱章小靛;荷止痒;homeboy813;陈明真儿-2;brave孙菥山同学;" +
			"MY张家三小姐;真美子芳;万顷湖平-四时月好;wrong晶晶;杨璐yrliss-1;杨璐yrliss-2;祥云飘飘2012;" +
			"杨璐-1;杨璐-2;杨璐yrliss-3;陈明真儿-3;叫我迷你小战士;速度-力量;homeboy813-2;淡少远的月亮;" +
			"巢穴部队-1;巢穴部队-2;二芜姑娘;清晏;Double L;蔡佳敏;我是方大胖;蘭奇;真理远走波士顿;皮生皮气;" +
			"阿良良误;哟;白云飘;真美子芳-2;川洁洁;祥云;康康;我是章小靛;妞妞小潘-1;妞妞小潘-2;妞妞小潘-3;妞妞小潘-4;" +
			"妞妞小潘-5;蹊桐;聪-1;聪-2";
	// 保存所有的用户名
	private List<String> userList = new ArrayList<String>();
	// 保存中奖的用户名
	private List<String> luckyUserList = new ArrayList<String>();
	// 定义几轮抽奖
	private int n = 3;
	/**
	 * 记录抽中的人的索引
	 */
	List<Integer> indexs = new ArrayList<Integer>();
	
	public LuckyDraw()
	{
		init();
	}
	
	

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}


	public String getUserNames() {
		return userNames;
	}

	public void setUserNames(String userNames) {
		this.userNames = userNames;
	}

	public List<String> getUserList() {
		return userList;
	}

	public void setUserList(List<String> userList) {
		this.userList = userList;
	}

	public List<String> getLuckyUserList() {
		return luckyUserList;
	}

	public void setLuckyUserList(List<String> luckyUserList) {
		this.luckyUserList = luckyUserList;
	}
	
	/**
	 * 数据初始化
	 */
	public void init(){
		userList.clear();
		String[] users = userNames.split(";");
		for(String name : users){
			if(!checkNameIsExist(name,userList))
			{
				userList.add(name);
			}
		}
		luckyUserList.clear();
		indexs.clear();
	}
	
	public boolean checkNameIsExist(String name,List<String> names){
		for(String n : names){
			if(n.indexOf(name.split("-")[0]) >= 0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 重新抽取
	 */
	public void reLuckyDraw(){
		init();
		luckyDraw();
	}
	
	// 抽奖
	public void luckyDraw(){
		init();
		
		List<String> l1 = getLuckMan(7);
		
		System.out.println("第一批中奖者：");
		for(String name : l1){
			System.out.println(name);
		}
		
		l1 = getLuckMan(7);
		
		System.out.println("第二批中奖者：");
		for(String name : l1){
			System.out.println(name);
		}
		l1 = getLuckMan(6);
		
		System.out.println("第三批中奖者：");
		for(String name : l1){
			System.out.println(name);
		}
		
		
		System.out.println("所有的中奖者：");
		for(String name : luckyUserList){
			System.out.println(name);
		}
		
	}
	
	/**
	 * 抽出几个人
	 * @param n 中奖人数
	 */
	public List<String> getLuckMan(int n ){
		
		List<String> men = new ArrayList<String>();
		
		if(userList.size() == 0){
			return null;
		}
		
		
		if(n >= userList.size()){
			luckyUserList.addAll(userList);
			men.addAll(userList);
			userList.clear();
			return men;
		}
		
		if(userList.size() > 0){
			indexs.clear();
			for(int i =0 ; i < n; i++){
				int index = getRandom();
				indexs.add(index);
				String name = userList.get(index);
				
				luckyUserList.add(name);
				men.add(name);
			}
			//System.out.println(indexs);
			removeLuckyMan();
		}
		
		return men;
		
	}
	/**
	 * 从原始名单中移除中奖人
	 */
	public void removeLuckyMan(){
		List<String> list = new ArrayList<String>();
		for(String name : luckyUserList){
			for(String n : userList){
				if(n.indexOf(name) >= 0){
					list.add(n);
				}
			}
		}
		
		for(String name : list){
			userList.remove(name);
		}
		
	}
	
	/**
	 * 获取随机数
	 * @return
	 */
	public int getRandom(){
		Random random1 = new Random();
		int n = random1.nextInt(userList.size());
		
		while(n < 0){
			n = random1.nextInt(userList.size());
			for(int nm : indexs){
				if(nm == n){
					n = -1;
					break;
				}
			}
		}
		
		for(int nm : indexs){
			if(nm == n){
				n = getRandom();
				break;
			}
		}
		
        return n;
	}
	
	public static void main(String[] args) {
		LuckyDraw ld = new LuckyDraw();
		ld.luckyDraw();
	}
	
}

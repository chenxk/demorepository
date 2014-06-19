package com.test.luan;
import java.util.ArrayList;
import java.util.List;



public class TTTTTT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Per> ss = new ArrayList<Per>();
		Per p = new Per("one");
		Per p2 = new Per("one2");
		Per p3 = new Per("one3");
		ss.add(p);
		ss.add(p2);
		ss.add(p3);
		
		dd(ss);
		
		for(Per pp:ss){
			System.out.println(pp.getName());
		}
		
		if(true){
			return;
		}
		
		
		List<Per> ss2 = new ArrayList<Per>();
		ss2.add(p);
		ss2.add(p3);
		
		//Per p4 = new Per("one");
		//p4.setName("11");
		//ss.remove(p);
		for(Per pp : ss2)
		{
			ss.remove(pp);
			//System.out.println(pp.getName());
		}
		
		for(Per pp:ss){
			System.out.println(pp.getName());
		}
		
	}
	
	public static Per dd(List<Per> list){
		list.clear();
		return null;
	}

}

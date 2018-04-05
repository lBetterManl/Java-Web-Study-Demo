package cn.test.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;



public class Demo02 {

	@Test
	public void test1(){
		List<String> list = new ArrayList<String>();
		list.add("1aa");
		list.add("1bb");
		list.add("1cc");
		
		//传统
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String value = it.next();
			System.out.println(value);
			
		}
		
		//增强for循环
		for(String s:list){
			System.out.println(s);
		}	
	}
	
	
	@Test
	public void test2(){
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();	//取的时候按顺序用LinkedHashMap
		map.put(1, "2aa");
		map.put(2, "2bb");
		map.put(3, "2cc");
		
		//传统keyset  entryset
		Set<Map.Entry<Integer, String>> set = map.entrySet();
		Iterator<Map.Entry<Integer, String>> it = set.iterator();
		while(it.hasNext()){
			Map.Entry<Integer, String> entry = it.next();
			int key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println(key+ "=" +value);
		}
		
		//增强for循环(重点)
		for(Map.Entry<Integer, String> entry:map.entrySet() ){
			int key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+ "=" +value);
		}
	}
	
}

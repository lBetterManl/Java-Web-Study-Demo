package cn.test.generic;

import java.util.ArrayList;
import java.util.List;

//����  ��߳�����ȶ���
public class Demo01 {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("aaa");
		
		Integer i = (Integer) list.get(0);
		
		List<String> list1 = new ArrayList<String>();
		list1.add("bbb");
		
		String s = list1.get(0);
		
		System.out.println("i:"+i);
		System.out.println("s:"+s);
	}
}

package cn.test.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo02 {

	public static void main(String[] args) {

		//1.5 jvm
		Integer i = 1;	//װ��
		int j = i;	//����
		
		//����Ӧ��
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Iterator it = list.iterator();
		while(it.hasNext()){
			int k= (Integer)it.next();	//����
		}

	}

}

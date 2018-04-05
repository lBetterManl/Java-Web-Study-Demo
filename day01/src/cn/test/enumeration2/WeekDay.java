package cn.test.enumeration2;

import org.junit.Test;

public class WeekDay {
	
	@Test
	public void testWeek(){
		print(Week.FRI);
	}
	
	public void print(Week w){	//A B C D E
		String value = w.getValue();
		System.out.println(value);
	}
	
	@Test
	public void test2(){
		String str = "MON";
		Week w = Week.valueOf(str);
		System.out.println(w);
		
		//����ö������ֵ
		Week Ww[] = Week.values();
		for(Week w1 : Ww){
			System.out.println(w1.getValue());
		}
		
		
	}
	
}

enum Week{
	MON("����һ")
	,TUE("���ڶ�")
	,WED("������")
	,THU("������")
	,FRI("������")
	,SAT("������")
	,SUN("������");
	
	private String value;	//��װÿ�������Ӧ�ķ���
	private Week(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
}
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
		
		//返回枚举所有值
		Week Ww[] = Week.values();
		for(Week w1 : Ww){
			System.out.println(w1.getValue());
		}
		
		
	}
	
}

enum Week{
	MON("星期一")
	,TUE("星期二")
	,WED("星期三")
	,THU("星期四")
	,FRI("星期五")
	,SAT("星期六")
	,SUN("星期日");
	
	private String value;	//封装每个对象对应的分数
	private Week(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
}
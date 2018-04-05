package cn.test.enumeration2;

import org.junit.Test;

public class Demo01 {

	/**
	 * 枚举型
	 */
	@Test
	public void test(){
		print(Grade.B);
	}
	
	public void print(Grade g){	//A B C D E
		String value1 = g.getValue();
		String value = g.localValue();
		System.out.println(value1);
		System.out.println(value);
	}
	
	//测试枚举的常用方法
	@Test
	public void test2(){
		System.out.println(Grade.C.name());
		System.out.println(Grade.C.ordinal());
		
		String str = "B";	//字符串转成枚举
		//Grade g = Grade.valueOf(Grade.class, str);
		Grade g = Grade.valueOf(str);
		System.out.println(g);
		
		//返回枚举所有值
		Grade gs[] = Grade.values();
		for(Grade g1 : gs){
			System.out.println(g1);
		}
		
	}

}


/*
class Grade{
	private Grade() {}
	public static final Grade A = new Grade();
	public static final Grade B = new Grade();
	public static final Grade C = new Grade();
	public static final Grade D = new Grade();
	public static final Grade E = new Grade();
	
}
*/

//带抽象方法的枚举

enum Grade{	//class A 100-90 优   B 89-80 良	 C 79-70 一般  D 69-60 差  E 59-0 不及格
	A("100-90"){
		public String localValue(){
			return "优";
		}
	}
	
	,B("89-80"){
		public String localValue(){
			return "良";
		}
	}
	
	,C("79-70"){
		public String localValue(){
			return "一般";
		}
	}
	
	,D("69-60"){
		public String localValue(){
			return "差";
		}
	}
	
	,E("59-0"){
		public String localValue(){
			return "不及格";
		}
	};	//object
	
	private String value;	//封装每个对象对应的分数
	private Grade(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public abstract String localValue();	//抽象类
}

//用单态设计模式定义了一个类
enum A {	//class
	
}
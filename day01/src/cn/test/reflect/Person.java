package cn.test.reflect;

import java.io.InputStream;
import java.util.List;

public class Person {
	
	public String name = "aaaa";
	private String password = "123";
	private static int age = 23;
	
	public Person(){
		System.out.println("person");
	}
	
	public Person(String name){
		System.out.println("person name");
	}
	
	public Person(String name, int password){
		System.out.println("person name password");
	}
	
	private Person(List list){
		System.out.println("list");
	}
	
	public void aa1(){
		System.out.println("aa1");
	}
	
	public void aa1(String name, int password){
		System.out.println(name + ":" + password);
	}

	public Class[] aa1(String name, int[] password){
		return new Class[]{String.class};
	}
	
	public void aa1(InputStream in){
		System.out.println(in);
	}
	
	public static void aa1(int num){
		System.out.println(num);
	}
	
	public static void main(String[] args){
		System.out.println("main!!!");
	}
}

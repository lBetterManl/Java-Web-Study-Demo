package cn.test.reflect;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

//反射类的构造函数，创建类的对象
public class Demo02 {

	// 反射构造函数，public Person()
	@Test
	public void test1() throws Exception {
		Class clazz = Class.forName("cn.test.reflect.Person");
		Constructor c = clazz.getConstructor(null);
		Person p = (Person) c.newInstance(null);

		System.out.println(p.name);
	}

	// 反射构造函数，public Person(String name)
	@Test
	public void test2() throws Exception {
		Class clazz = Class.forName("cn.test.reflect.Person");
		Constructor c = clazz.getConstructor(String.class);
		Person p = (Person) c.newInstance("XXX");
		System.out.println(p.name);
	}

	// 反射构造函数，public Person(String name, int password)
	@Test
	public void test3() throws Exception {
		Class clazz = Class.forName("cn.test.reflect.Person");
		Constructor c = clazz.getConstructor(String.class, int.class);
		
		Person p = (Person) c.newInstance("XXXX",12);
		System.out.println(p.name);
	}
	
	//private Person(List list)私有的外部不能访问，但是反射可以做到
	@Test
	public void test4() throws Exception {
		Class clazz = Class.forName("cn.test.reflect.Person");
		Constructor c = clazz.getDeclaredConstructor(List.class);	//public
		c.setAccessible(true);	//暴力反射
		Person p = (Person) c.newInstance(new ArrayList());
		System.out.println(p.name);
	}
	
	//创建对象的另外一种途径；以下代码等价于test1（）
	@Test
	public void test5() throws Exception {
		Class clazz = Class.forName("cn.test.reflect.Person");
		Person p = (Person) clazz.newInstance();
		System.out.println(p.name);
	}

}

 package cn.test.reflect;

import java.lang.reflect.Field;

import org.junit.Test;

//反射字段
public class Demo04 {

	// 反射字段：public String name = "aaaa";
	@Test
	public void test1() throws Exception {
		Person p = new Person();
		Class clazz = Class.forName("cn.test.reflect.Person");
		Field f = clazz.getField("name");
		// 获取字段的值
		Object value = f.get(p);
		// 获取字段的类型
		Class type = f.getType();
		if (type.equals(String.class)) {
			String svalue = (String) value;
			System.out.println(svalue);
		}

		// 设置字段的值
		f.set(p, "XXOO");
		System.out.println(p.name);

	}

	// 反射字段：private String password;
	@Test
	public void test2() throws Exception {
		Person p = new Person();
		Class clazz = Class.forName("cn.test.reflect.Person");
		Field f = clazz.getDeclaredField("password");
		f.setAccessible(true);
		System.out.println(f.get(p));

	}

	// 反射字段：private static int age = 23;
	@Test
	public void test3() throws Exception {
		Person p = new Person();
		Class clazz = Class.forName("cn.test.reflect.Person");
		Field f = clazz.getDeclaredField("age");
		f.setAccessible(true);
		System.out.println(f.get(p));

	}
}

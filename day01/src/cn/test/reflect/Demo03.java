package cn.test.reflect;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.junit.Test;

//������ķ���
public class Demo03 {

	// ������ķ�����public void aa1()
	@Test
	public void test1() throws Exception {

		Person p = new Person();
		Class clazz = Class.forName("cn.test.reflect.Person");
		Method method = clazz.getMethod("all", null);
		method.invoke(p, null);
	}

	// ������ķ�����public void aa1(String name, int password)
	@Test
	public void test2() throws Exception {
		Person p = new Person();
		Class clazz = Class.forName("cn.test.reflect.Person");
		Method method = clazz.getMethod("aa1", String.class, int.class);
		method.invoke(p, "zxx", 36);
	}

	// ������ķ�����public Class[] aa1(String name, int[] password)
	@Test
	public void test3() throws Exception {
		Person p = new Person();
		Class clazz = Class.forName("cn.test.reflect.Person");
		Method method = clazz.getMethod("aa1", String.class, int[].class);
		Class cs[] = (Class[]) method.invoke(p, "aaaa", new int[] { 1, 2, 3 });
		System.out.println(cs[0]);
	}

	// ������ķ�����public void aa1(InputStream in)
	@Test
	public void test4() throws Exception {
		Person p = new Person();
		Class clazz = Class.forName("cn.test.reflect.Person");
		Method method = clazz.getMethod("aa1", String.class, int[].class);
		method.setAccessible(true);
		method.invoke(p, new FileInputStream("src/cn/test/reflect/test03.txt"));
	}

	// ������ķ�����public static void aa1(int num)
	@Test
	public void test5() throws Exception {
		Person p = new Person();
		Class clazz = Class.forName("cn.test.reflect.Person");
		Method method = clazz.getMethod("aa1", int.class);
		method.invoke(null,23);
	}
	
	// ������ķ�����public static void main(String[] args)
		@Test
		public void test6() throws Exception {
			Person p = new Person();
			Class clazz = Class.forName("cn.test.reflect.Person");
			Method method = clazz.getMethod("main", String[].class);
			method.invoke(null,(Object)new String[]{"aa","bb"});
		}
}

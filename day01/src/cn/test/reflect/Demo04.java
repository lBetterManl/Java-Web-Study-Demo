 package cn.test.reflect;

import java.lang.reflect.Field;

import org.junit.Test;

//�����ֶ�
public class Demo04 {

	// �����ֶΣ�public String name = "aaaa";
	@Test
	public void test1() throws Exception {
		Person p = new Person();
		Class clazz = Class.forName("cn.test.reflect.Person");
		Field f = clazz.getField("name");
		// ��ȡ�ֶε�ֵ
		Object value = f.get(p);
		// ��ȡ�ֶε�����
		Class type = f.getType();
		if (type.equals(String.class)) {
			String svalue = (String) value;
			System.out.println(svalue);
		}

		// �����ֶε�ֵ
		f.set(p, "XXOO");
		System.out.println(p.name);

	}

	// �����ֶΣ�private String password;
	@Test
	public void test2() throws Exception {
		Person p = new Person();
		Class clazz = Class.forName("cn.test.reflect.Person");
		Field f = clazz.getDeclaredField("password");
		f.setAccessible(true);
		System.out.println(f.get(p));

	}

	// �����ֶΣ�private static int age = 23;
	@Test
	public void test3() throws Exception {
		Person p = new Person();
		Class clazz = Class.forName("cn.test.reflect.Person");
		Field f = clazz.getDeclaredField("age");
		f.setAccessible(true);
		System.out.println(f.get(p));

	}
}

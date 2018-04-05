package cn.test.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

import cn.test.introspector.Person;

//ʹ��beanutils����bean�����ԣ���������
public class Demo01 {

	@Test
	public void test1() throws IllegalAccessException, InvocationTargetException{
		
		Person p = new Person();
		BeanUtils.setProperty(p, "name", "XXOO");
		
		System.out.println(p.getName());	
	}
	
	//����Ĵ��������⣬��ΪBeanutilsֻ֧�ֻ����������͵�ת��
	@Test
	public void test2() throws IllegalAccessException, InvocationTargetException{
		
		String name = "aaa";
		String password = "123";
		String age = "34";
		String birthday = "1993-08-28";
		
		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);	//ֻ֧�ְ��ֻ����������͵�ת��
		BeanUtils.setProperty(p, "birthday", birthday);	//ֻ֧�ְ��ֻ����������͵�ת��
		
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());
		System.out.println(p.getBirthday());
		
	}
	
	@Test
	public void test3() throws IllegalAccessException, InvocationTargetException{
		
		String name = "aaa";
		String password = "123";
		String age = "34";
		String birthday = "1993-08-28";
		
		//Ϊ�������ڸ���bean��birthday������,���Ǹ�Beanutilsע��һ������ת����
		ConvertUtils.register(new Converter() {
			
			public Object convert(Class type, Object value) {
				
				if (value==null) {
					return null;	
				}
				
				if (!(value instanceof String)) {	//�ж��Ƿ�Ϊ�ַ���
					throw new ConversionException("ֻ֧��String����ת��");
				}
				
				String str = (String) value;
				if (str.trim().equals("")) {
					return null;
				}
				
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parse(str);
				} catch (ParseException e) {
					throw new RuntimeException(e);	//�쳣�����ܶ�
				}
				
			}
		}, Date.class);
		
		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);	//ֻ֧�ְ��ֻ����������͵�ת��
		BeanUtils.setProperty(p, "birthday", birthday);	//ֻ֧�ְ��ֻ����������͵�ת��
		
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());
//		System.out.println(p.getBirthday());
		Date date = p.getBirthday();
		System.out.println(date.toString());
	}
	
	//DateLocaleConverter()ת����  birthdayΪ""ʱ������
	@Test
	public void test4() throws IllegalAccessException, InvocationTargetException{
		
		String name = "aaa";
		String password = "123";
		String age = "34";
		String birthday = "1993-08-28";
		
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		
		
		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);	//ֻ֧�ְ��ֻ����������͵�ת��
		BeanUtils.setProperty(p, "birthday", birthday);	//ֻ֧�ְ��ֻ����������͵�ת��
		
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());
//		System.out.println(p.getBirthday());
		Date date = p.getBirthday();
		System.out.println(date.toString());
	}
	
	
	//
	@Test
	public void test5() throws IllegalAccessException, InvocationTargetException{
		
		Map map = new HashMap();
		map.put("name", "yhc");
		map.put("password", "123");
		map.put("age", "22");
		map.put("birthday", "1994-08-28");
		
		ConvertUtils.register(new DateLocaleConverter(), Date.class);	//clazz ��������.class
		Person bean = new Person();
		BeanUtils.populate(bean, map);	//��map�����е�ֵ���bean������
		
		System.out.println("������"+bean.getName());
		System.out.println("���룺"+bean.getPassword());
		System.out.println("���䣺"+bean.getAge());
		System.out.println("���գ�"+bean.getBirthday());
	}
	
}

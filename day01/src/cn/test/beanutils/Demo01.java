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

//使用beanutils操纵bean的属性（第三方）
public class Demo01 {

	@Test
	public void test1() throws IllegalAccessException, InvocationTargetException{
		
		Person p = new Person();
		BeanUtils.setProperty(p, "name", "XXOO");
		
		System.out.println(p.getName());	
	}
	
	//下面的代码有问题，因为Beanutils只支持基本数据类型的转化
	@Test
	public void test2() throws IllegalAccessException, InvocationTargetException{
		
		String name = "aaa";
		String password = "123";
		String age = "34";
		String birthday = "1993-08-28";
		
		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);	//只支持八种基本数据类型的转换
		BeanUtils.setProperty(p, "birthday", birthday);	//只支持八种基本数据类型的转换
		
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
		
		//为了让日期赋到bean的birthday属性上,我们给Beanutils注册一个日期转换器
		ConvertUtils.register(new Converter() {
			
			public Object convert(Class type, Object value) {
				
				if (value==null) {
					return null;	
				}
				
				if (!(value instanceof String)) {	//判断是否为字符串
					throw new ConversionException("只支持String类型转换");
				}
				
				String str = (String) value;
				if (str.trim().equals("")) {
					return null;
				}
				
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return df.parse(str);
				} catch (ParseException e) {
					throw new RuntimeException(e);	//异常链不能断
				}
				
			}
		}, Date.class);
		
		Person p = new Person();
		BeanUtils.setProperty(p, "name", name);
		BeanUtils.setProperty(p, "password", password);
		BeanUtils.setProperty(p, "age", age);	//只支持八种基本数据类型的转换
		BeanUtils.setProperty(p, "birthday", birthday);	//只支持八种基本数据类型的转换
		
		System.out.println(p.getName());
		System.out.println(p.getPassword());
		System.out.println(p.getAge());
//		System.out.println(p.getBirthday());
		Date date = p.getBirthday();
		System.out.println(date.toString());
	}
	
	//DateLocaleConverter()转换器  birthday为""时出问题
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
		BeanUtils.setProperty(p, "age", age);	//只支持八种基本数据类型的转换
		BeanUtils.setProperty(p, "birthday", birthday);	//只支持八种基本数据类型的转换
		
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
		
		ConvertUtils.register(new DateLocaleConverter(), Date.class);	//clazz 数据类型.class
		Person bean = new Person();
		BeanUtils.populate(bean, map);	//用map集合中的值填充bean的属性
		
		System.out.println("姓名："+bean.getName());
		System.out.println("密码："+bean.getPassword());
		System.out.println("年龄："+bean.getAge());
		System.out.println("生日："+bean.getBirthday());
	}
	
}

package cn.test.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;




//使用内省api操作bean属性
public class Demo01 {

	@Test
	public void test1() throws Exception{
		BeanInfo info = Introspector.getBeanInfo(Person.class);
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		for(PropertyDescriptor pd : pds){
			System.out.println(pd.getName());
		}
	}
	
	
	//操纵bean的制定属性：age
	@Test
	public void test2() throws Exception{
		Person p = new Person();
		
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		
		//得到属性的写方法，为属性赋值
		Method method = pd.getWriteMethod();
		method.invoke(p, 22);
		
		//获取属性的值
		method = pd.getReadMethod();	//public int getAge()
		System.out.println(method.invoke(p, null));
		
	}
	
	
	//高级点的内容，获取当前操作的属性的类型
	@Test
	public void test3() throws Exception{
		Person p = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		System.out.println(pd.getPropertyType());
		
	}
	
}

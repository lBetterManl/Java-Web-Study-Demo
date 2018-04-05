package cn.test.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;




//ʹ����ʡapi����bean����
public class Demo01 {

	@Test
	public void test1() throws Exception{
		BeanInfo info = Introspector.getBeanInfo(Person.class);
		PropertyDescriptor[] pds = info.getPropertyDescriptors();
		for(PropertyDescriptor pd : pds){
			System.out.println(pd.getName());
		}
	}
	
	
	//����bean���ƶ����ԣ�age
	@Test
	public void test2() throws Exception{
		Person p = new Person();
		
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		
		//�õ����Ե�д������Ϊ���Ը�ֵ
		Method method = pd.getWriteMethod();
		method.invoke(p, 22);
		
		//��ȡ���Ե�ֵ
		method = pd.getReadMethod();	//public int getAge()
		System.out.println(method.invoke(p, null));
		
	}
	
	
	//�߼�������ݣ���ȡ��ǰ���������Ե�����
	@Test
	public void test3() throws Exception{
		Person p = new Person();
		PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
		System.out.println(pd.getPropertyType());
		
	}
	
}

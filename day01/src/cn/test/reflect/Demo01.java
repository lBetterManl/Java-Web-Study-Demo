package cn.test.reflect;

public class Demo01 {

	/**
	 * 反射加载类,获得类的字节码
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {

		//1.
		Class clazz = Class.forName("cn.test.reflect.Person.java");

		//2.
		Class clazz1 = new Person().getClass();
		
		//3.
		Class clazz2 = Person.class;
	}

}

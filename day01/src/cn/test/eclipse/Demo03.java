package cn.test.eclipse;

import org.junit.Test;

//Person�Ĳ�����
public class Demo03 {
	
	//��@Test��Junit����
	@Test
	public void testRun(){
		Person p = new Person();
		p.run();
	}
	
	@Test
	public void testEat() {
		Person p = new Person();
		p.eat();
		
	}

}

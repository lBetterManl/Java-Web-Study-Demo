package cn.test.eclipse;

import org.junit.Test;

//Person的测试类
public class Demo03 {
	
	//加@Test用Junit测试
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

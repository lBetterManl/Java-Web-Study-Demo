package cn.test.eclipse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Person≤‚ ‘¿‡ JUnit≤‚ ‘
public class Demo04 {
	
	private Person p;
	
	@Before
	public void before(){
		p = new Person();
	}
	
	@Test
	public void testRun(){
		p.run();
	}
	
	@Test
	public void testEat(){
		p.eat();
	}
	
	@After
	public void after(){
		p = null;
	}
}

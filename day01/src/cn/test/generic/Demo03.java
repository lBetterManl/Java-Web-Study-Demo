package cn.test.generic;

import org.junit.Test;


//自定义带泛形的方法
public class Demo03 {
	@Test
	public void testa() {
		a("1a");
	}

	public<T> T a(T t) {
		return null;
	}
	
	public<T,E,K> void b(T t,E e,K k){
		
	}
}

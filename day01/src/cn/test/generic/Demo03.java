package cn.test.generic;

import org.junit.Test;


//�Զ�������εķ���
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

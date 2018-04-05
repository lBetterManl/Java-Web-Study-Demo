package cn.test.generic;

//自定义类上的泛形,对static无效
//类上声明的泛形作用在整个范围内,则方法中public后<>可省略
public class Demo04<T,E,K> {
	
	public void testa() {
		
	}
	
	public T a(T t) {
		return null;
		
	}
	
	public void b(T t,E e,K k) {
		
	}
	
	//声明在static后面
	public static<T> void c(T t) {
		
	}

}

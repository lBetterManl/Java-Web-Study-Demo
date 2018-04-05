package cn.test.enumeration2;

import org.junit.Test;

public class Demo01 {

	/**
	 * ö����
	 */
	@Test
	public void test(){
		print(Grade.B);
	}
	
	public void print(Grade g){	//A B C D E
		String value1 = g.getValue();
		String value = g.localValue();
		System.out.println(value1);
		System.out.println(value);
	}
	
	//����ö�ٵĳ��÷���
	@Test
	public void test2(){
		System.out.println(Grade.C.name());
		System.out.println(Grade.C.ordinal());
		
		String str = "B";	//�ַ���ת��ö��
		//Grade g = Grade.valueOf(Grade.class, str);
		Grade g = Grade.valueOf(str);
		System.out.println(g);
		
		//����ö������ֵ
		Grade gs[] = Grade.values();
		for(Grade g1 : gs){
			System.out.println(g1);
		}
		
	}

}


/*
class Grade{
	private Grade() {}
	public static final Grade A = new Grade();
	public static final Grade B = new Grade();
	public static final Grade C = new Grade();
	public static final Grade D = new Grade();
	public static final Grade E = new Grade();
	
}
*/

//�����󷽷���ö��

enum Grade{	//class A 100-90 ��   B 89-80 ��	 C 79-70 һ��  D 69-60 ��  E 59-0 ������
	A("100-90"){
		public String localValue(){
			return "��";
		}
	}
	
	,B("89-80"){
		public String localValue(){
			return "��";
		}
	}
	
	,C("79-70"){
		public String localValue(){
			return "һ��";
		}
	}
	
	,D("69-60"){
		public String localValue(){
			return "��";
		}
	}
	
	,E("59-0"){
		public String localValue(){
			return "������";
		}
	};	//object
	
	private String value;	//��װÿ�������Ӧ�ķ���
	private Grade(String value){
		this.value = value;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public abstract String localValue();	//������
}

//�õ�̬���ģʽ������һ����
enum A {	//class
	
}
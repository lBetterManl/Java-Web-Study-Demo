package cn.test.eclipse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo02 {

	/**
	 ��ݼ�
	 */
	public static void main(String[] args) {
		//alt+/ ��������
		try {
			FileInputStream in = new FileInputStream("");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//�����޸� Ctrl+1
		List list = new ArrayList();
		try {
			FileInputStream in1 = new FileInputStream("");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//���� Ctrl + shift + o
		Set set = new HashSet();
		
		//��ʽ�������Ctrl + shift + F
		try {
			FileInputStream in2 = new FileInputStream("");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//����Ctrl��������Դ��  Alt + ������鿴���¼�Դ��
		Set set1 = new HashSet();
		
		//���ע�� Ctrl+shift+/
		//����ע�� Ctrl+shift+/
		
		//�鿴����˵��F2
		Set set2 = new HashSet();
		set2.add("aaa");
		
		//����͸��ͼwindow reset
		//���Ĵ�дΪСд Ctrl shift X��д  YСд
		
		//������Ctrl Alt ���¼������ƣ� 
		
		//Alt+���ϡ��¼� ���ϻ����ƶ�
		
		//�鿴��ļ̳й�ϵ Ctrl+T
		Set set3= new HashSet();
		
		//�鿴Դ����ctrl+shift+T
		
		//Ctrl+shift+L�鿴���п�ݼ�
		
	}

}

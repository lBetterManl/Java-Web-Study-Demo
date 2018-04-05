package cn.test.eclipse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Demo02 {

	/**
	 快捷键
	 */
	public static void main(String[] args) {
		//alt+/ 内容助理
		try {
			FileInputStream in = new FileInputStream("");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//快速修复 Ctrl+1
		List list = new ArrayList();
		try {
			FileInputStream in1 = new FileInputStream("");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//导包 Ctrl + shift + o
		Set set = new HashSet();
		
		//格式化代码块Ctrl + shift + F
		try {
			FileInputStream in2 = new FileInputStream("");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//按下Ctrl鼠标左键看源码  Alt + 方向键查看上下级源码
		Set set1 = new HashSet();
		
		//添加注释 Ctrl+shift+/
		//消除注释 Ctrl+shift+/
		
		//查看方法说明F2
		Set set2 = new HashSet();
		set2.add("aaa");
		
		//重置透视图window reset
		//更改大写为小写 Ctrl shift X大写  Y小写
		
		//复制行Ctrl Alt 向下键（复制） 
		
		//Alt+向上、下键 向上或下移动
		
		//查看类的继承关系 Ctrl+T
		Set set3= new HashSet();
		
		//查看源代码ctrl+shift+T
		
		//Ctrl+shift+L查看所有快捷键
		
	}

}

package com.yhc.json;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.xml.XMLSerializer;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月3日 下午4:46:34
 * @see 对象转化成JSON
 */
public class Obj2Json {

	// Array转化成Json
	@Test
	public void array2json() {

		// int[] intArray
		int[] intArray = new int[] { 1, 4, 5 };
		JSONArray jsonArray1 = JSONArray.fromObject(intArray);
		System.out.println("int[] intArray----->" + jsonArray1);

		// boolean[] boolArray
		boolean[] boolArray = new boolean[] { true, false, true };
		JSONArray jsonArray2 = JSONArray.fromObject(boolArray);
		System.out.println("boolean[] boolArray----->" + jsonArray2);

		// int[][] int2Array
		int[][] int2Array = new int[][] { { 1, 2 }, { 3, 4 } };
		JSONArray jsonArray3 = JSONArray.fromObject(int2Array);
		System.out.println("int[][] int2Array----->" + jsonArray3);

		// float[] floatArray
		float[] floatArray = new float[] { 0.1f, 0.2f, 0.3f };
		JSONArray jsonArray4 = JSONArray.fromObject(floatArray);
		System.out.println("float[] floatArray----->" + jsonArray4);

		// String[] strArray
		String[] strArray = new String[] { "hello", "hebut", "xiapi" };
		JSONArray jsonArray5 = JSONArray.fromObject(strArray);
		System.out.println("String[] strArray----->" + jsonArray5);

	}

	// Collection转化成Json
	@Test
	public void collection2json() {

		// List
		List list1 = new ArrayList();
		list1.add("first");
		list1.add("second");
		JSONArray jsonArray1 = JSONArray.fromObject(list1);
		System.out.println("List----->" + jsonArray1);

		// List<Student>
		List<Student> list2 = new ArrayList<Student>();
		list2.add(new Student("男神", "男", 22));
		list2.add(new Student("女神", "女", 20));
		list2.add(new Student("屌丝", "男", 22));
		JSONArray jsonArray2 = JSONArray.fromObject(list2);
		System.out.println("List<Student>----->" + jsonArray2);
	}

	// Map转化成Json
	@Test
	public void map2json() {

		// Map
		Map map1 = new HashMap();
		map1.put("name", "json");
		map1.put("bool", Boolean.TRUE);
		map1.put("int", new Integer(1));
		map1.put("arr", new String[] { "a", "b" });
		map1.put("func", "function(i){return this.arr[i];}");
		JSONObject jsonObject1 = JSONObject.fromObject(map1);
		System.out.println("Map----->" + map1);

		// Map<String,Student>
		Map<String, Student> map2 = new HashMap<String, Student>();
		map2.put("k1", new Student("stu1", "男", 20));
		map2.put("k2", new Student("stu2", "女", 22));
		map2.put("k3", new Student("stu3", "男", 24));
		JSONObject jsonObject2 = JSONObject.fromObject(map2);
		System.out.println("Map<String,Student>----->" + jsonObject2);
	}

	// Bean转化成Json
	@Test
	public void bean2json() {

		Student s1 = new Student("xiapi", "男", 22);
		JSONObject jsonObject1 = JSONObject.fromObject(s1);
		System.out.println("Student-----》" + jsonObject1);

		Class c1 = new Class();
		c1.setName("计算机应用1班");
		c1.setDate(new Date());
		JsonConfig config = new JsonConfig();
		// 设置循环策略为忽略
		config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		// 设置 json转换的处理器用来处理日期类型
		// 凡是反序列化Date类型的对象，都会经过该处理器进行处理
		config.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
			// 参数1 ：属性名参数2：json对象的值参数3：jsonConfig对象
			public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date d = (Date) arg1;
				return sdf.format(d);
			}

			public Object processArrayValue(Object arg0, JsonConfig arg1) {
				return null;
			}
		});
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("xiapi1", "男", 10));
		students.add(new Student("xiapi2", "女", 11));
		students.add(new Student("xiapi3", "男", 12));
		c1.setStudents(students);
		JSONObject jsonObject2 = JSONObject.fromObject(c1, config);
		System.out.println("Class c1");
		System.out.println(jsonObject2);
	}

	// xml转化成json
	@Test
	public void xml2json() {
		String s = "<student><name id='n1'>男神</name><sex class='s1'>男</sex><age>20</age></student>";
		XMLSerializer x = new XMLSerializer();
		JSON json = x.read(s);
		System.out.println("s----->"+json);
	}

}

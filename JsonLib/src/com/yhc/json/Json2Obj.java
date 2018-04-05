package com.yhc.json;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import net.sf.ezmorph.Morpher;
import net.sf.ezmorph.MorpherRegistry;
import net.sf.ezmorph.bean.BeanMorpher;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.ezmorph.test.ArrayAssertions;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import net.sf.json.xml.XMLSerializer;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月3日 下午6:19:22
 */
public class Json2Obj {

	@Test
	public void json2arrays() {
		String json1 = "['first','second']";
		JSONArray jsonArray1 = (JSONArray) JSONSerializer.toJSON(json1);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setArrayMode(JsonConfig.MODE_OBJECT_ARRAY);
		Object[] output1 = (Object[]) JSONSerializer.toJava(jsonArray1, jsonConfig);
		Object[] expected = new Object[] { "first", "second" };
		ArrayAssertions.assertEquals(expected, output1);
		System.out.println("Object[]");
		System.out.println(output1.length);
		System.out.println(output1[1]);

		String json2 = "[[1,2],[3,4]]";
		JSONArray jsonArray2 = JSONArray.fromObject(json2);
		Object[][] output2 = (Object[][]) JSONArray.toArray(jsonArray2);
		System.out.println("Object[][]");
		System.out.println(output2.length);
		System.out.println(output2[0][0]);
	}

	@Test
	public void json2collections() {
		String json1 = "['first','second']";
		JSONArray jsonArray1 = (JSONArray) JSONSerializer.toJSON(json1);
		List output1 = (List) JSONSerializer.toJava(jsonArray1);
		System.out.println("List");
		System.out.println(output1.get(0));

		String json2 = "[{'age':10,'sex':'男','username':'xiapi1'},{'age':11,'sex':'女','username':'xiapi2'}]";
		JSONArray jsonArray2 = JSONArray.fromObject(json2);
		List<Student> output2 = JSONArray.toList(jsonArray2, Student.class);
		System.out.println("List<Student>");
		System.out.println(output2.size());
		System.out.println(output2.get(0));
		System.out.println(output2.get(0).getUsername());
	}

	@Test
	public void json2map() {
		String json1 = "{'arr':['a','b'],'int':1,'name':'json','bool':true}";
		JSONObject jsonObject1 = JSONObject.fromObject(json1);
		Map typeMap1 = new HashMap();
		typeMap1.put("arr", String[].class);
		typeMap1.put("int", Integer.class);
		typeMap1.put("name", String.class);
		typeMap1.put("bool", Boolean.class);
		Map output1 = (Map) JSONObject.toBean(jsonObject1, Map.class, typeMap1);
		System.out.println("Map");
		System.out.println(output1.size());
		System.out.println(output1.get("name"));
		System.out.println(output1.get("arr"));

		String json2 = "{'k1':{'age':10,'sex':'男','userName':'xiapi1'},'k2':{'age':12,'sex':'女','userName':'xiapi2'}}";
		JSONObject jsonObject2 = JSONObject.fromObject(json2);
		Map<String, Class> typeMap2 = new HashMap<String, Class>();
		Map<String, Student> output2 = (Map<String, Student>) JSONObject.toBean(jsonObject2, Map.class, typeMap2);
		System.out.println("Map<String,Student>");
		System.out.println(output2.size());
		System.out.println(output2.get("k1"));

		// 先往注册器中注册变换器，需要用到ezmorph包中的类
		MorpherRegistry morpherRegistry = JSONUtils.getMorpherRegistry();
		Morpher dynaMorpher = new BeanMorpher(Student.class, morpherRegistry);
		morpherRegistry.registerMorpher(dynaMorpher);

		System.out.println(((Student) morpherRegistry.morph(Student.class, output2.get("k2"))).getUsername());
	}

	@Test
	public void json2bean() {
		// 简单对象
		String json1 = "{'age':22,'sex':'男','username':'xiapi'}";
		JSONObject jsonObject1 = JSONObject.fromObject(json1);
		Student output1 = (Student) JSONObject.toBean(jsonObject1, Student.class);
		System.out.println("Student");
		System.out.println(output1.getUsername());

		// 复杂对象
		String json2 = "{'date':'2012-05-21 13:03:11','name':'计算机应用1班','students':[{'age':10,'sex':'男','username':'xiapi1'},{'age':11,'sex':'女','username':'xiapi2'}]}";

		// 转为日期
		String[] DATE_FORMAT = { "yyyy-MM-dd HH:mm:ss" };
		MorpherRegistry morpherRegistry = JSONUtils.getMorpherRegistry();
		morpherRegistry.registerMorpher(new DateMorpher(DATE_FORMAT));
		JSONObject jsonObject2 = JSONObject.fromObject(json2);
		Map typeMap1 = new HashMap();
		typeMap1.put("date", Date.class);
		typeMap1.put("name", String.class);
		typeMap1.put("students", Student.class);
		Class output2 = (Class) JSONObject.toBean(jsonObject2, Class.class, typeMap1);
		System.out.println("Class");
		System.out.println(output2.getName());
		System.out.println(output2.getDate());
		System.out.println(output2.getStudents().get(0).getUsername());
	}
	
	@Test
    public void json2xml(){
        String json1 = "{'age':22,'sex':'男','userName':'xiapi'}";
        JSONObject jsonObj = JSONObject.fromObject(json1);
        XMLSerializer x = new XMLSerializer();
		String xml = x.write(jsonObj);
		System.out.println("XML");
		System.out.println(xml);
    }
	
	 @Test
	    public void testJSONArray() {
	        JSONArray jsonArray = new JSONArray();
	        jsonArray.add(0,"第一个值");
	        jsonArray.add(1,"第二个值");
	        jsonArray.add(2,"第三个值");
	        System.out.print(jsonArray.toString());
	    }
}

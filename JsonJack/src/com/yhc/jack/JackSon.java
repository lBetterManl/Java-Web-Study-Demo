package com.yhc.jack;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月4日 下午3:02:38
 */
public class JackSon {

	private JsonGenerator jsonGenerator = null;
	private ObjectMapper objectMapper = null;
	private User user;

	@Before
	public void init() {

		user = new User();
		user.setName("男神");
		user.setPwd("123");

		objectMapper = new ObjectMapper();
		try {
			jsonGenerator = objectMapper.getFactory().createGenerator(System.out,
					JsonEncoding.UTF8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@After
	public void destory() {

		try {
			if (jsonGenerator != null) {
				jsonGenerator.flush();
			}
			if (!jsonGenerator.isClosed()) {
				jsonGenerator.close();
			}
			jsonGenerator = null;
			objectMapper = null;
			user = null;
			System.gc();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void obj2Json(){
		try {
	        System.out.println("jsonGenerator");
	        //writeObject可以转换java对象，eg:JavaBean/Map/List/Array等
	        jsonGenerator.writeObject(user);    
	        System.out.println();
	        
	        System.out.println("ObjectMapper");
	        //writeValue具有和writeObject相同的功能
	        objectMapper.writeValue(System.out, user);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	@Test
	public void writeOthersJSON() {
	    try {
	        String[] arr = { "a", "b", "c" };
	        System.out.println("jsonGenerator");
	        String str = "hello world jackson!";
	        //byte
	        jsonGenerator.writeBinary(str.getBytes());
	        //boolean
	        jsonGenerator.writeBoolean(true);
	        //null
	        jsonGenerator.writeNull();
	        //float
	        jsonGenerator.writeNumber(2.2f);
	        //char
	        jsonGenerator.writeRaw("c");
	        //String
	        jsonGenerator.writeRaw(str, 5, 10);
	        //String
	        jsonGenerator.writeRawValue(str, 5, 5);
	        //String
	        jsonGenerator.writeString(str);
	        jsonGenerator.writeTree(JsonNodeFactory.instance.pojoNode(str));
	        System.out.println();
	        
	        //Object
	        jsonGenerator.writeStartObject();//{
	        jsonGenerator.writeObjectFieldStart("user");//user:{
	        jsonGenerator.writeStringField("name", "jackson");//name:jackson
	        jsonGenerator.writeBooleanField("sex", true);//sex:true
	        jsonGenerator.writeNumberField("age", 22);//age:22
	        jsonGenerator.writeEndObject();//}
	        
	        jsonGenerator.writeArrayFieldStart("infos");//infos:[
	        jsonGenerator.writeNumber(22);//22
	        jsonGenerator.writeString("this is array");//this is array
	        jsonGenerator.writeEndArray();//]
	        
	        jsonGenerator.writeEndObject();//}
	        
	        
	        User bean = new User();
	        bean.setName("haha");
	        bean.setPwd("123");
	        //complex Object
	        jsonGenerator.writeStartObject();//{
	        jsonGenerator.writeObjectField("user", bean);//user:{bean}
	        jsonGenerator.writeObjectField("infos", arr);//infos:[array]
	        jsonGenerator.writeEndObject();//}
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
	//都用readValue
	@Test
	public void json2Obj(){
		 String json = "{\"name\":\"haha\",\"pwd\":1}";
		    try {
		        User acc = objectMapper.readValue(json, User.class);
		        System.out.println(acc.getName());
		        System.out.println(acc);
		    } catch (JsonParseException e) {
		        e.printStackTrace();
		    } catch (JsonMappingException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	}
}

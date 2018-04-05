package com.yhc.jack;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月7日 下午8:54:49
 */
public class TestStu {

	@Test
	public void stu2Json() throws ParseException, JsonProcessingException {
		Student stu = new Student();
		stu.setStuname("男神");
		stu.setAge(23);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		stu.setBirthday(dateFormat.parse("1993-08-28"));

		/**
		 * ObjectMapper是JSON操作的核心，Jackson的所有JSON操作都是在ObjectMapper中实现。
		 * ObjectMapper有多个JSON序列化的方法，可以把JSON字符串保存File、OutputStream等不同的介质中。
		 * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
		 * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
		 * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
		 * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
		 */
		ObjectMapper mapper = new ObjectMapper();

		// Student转化成Json
		String json = mapper.writeValueAsString(stu);
		System.out.println(json);
	}

	@Test
	public void jsob2Stu() throws JsonParseException, JsonMappingException, IOException {
		String json = "{\"stuname\":\"男神\",\"birthday\":\"844099200000\",\"age\":20}";
		/**
		 * ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
		 */
		ObjectMapper mapper = new ObjectMapper();
		Student stu = mapper.readValue(json, Student.class);
		System.out.println(stu);
	}
}

package com.yhc.json;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.util.PropertyFilter;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月3日 下午6:38:36
 * @see 过滤字段
 */
public class JsonExclude {

	@Test
	public void obj2Json(){
		//创建对象
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("学生","男",20));
		Class clas = new Class("班级", new Date(), students);
		//创建jsonConfig对象
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);

		//设置过滤字段（不能过滤其中的students）
		config.setExcludes(new String[]{"name"});
		
		config.setJsonPropertyFilter(new PropertyFilter() {

			@Override
			public boolean apply(Object source, String name, Object value) {
				// TODO 过滤Applicant 和空值
				return ((source instanceof Class && name.equals("class")) || value==null);
			}
		});

		String json = JSONObject.fromObject(clas, config).toString();
		System.out.println("Class过滤name属性----->"+json);
	}
	
	@Test
	public void obj2Json2(){
		//创建对象
        Student stu= new Student("男神","男",22);
        //创建jsonConfig对象
        JsonConfig config=new JsonConfig();
        //设置过滤字段
        config.setJsonPropertyFilter(new PropertyFilter() {
            public boolean apply(Object arg0, String arg1, Object arg2) {
                if("username".equals(arg1)){
                    return true;
                }
                return false;
            }
        });
        String s=JSONObject.fromObject(stu,config).toString();
        System.out.println(s);
	}
	
	//解决死循环和时间格式问题
	@Test
	public void obj2Json3(){
		 //创建对象
        Class cls = new Class();
        //创建jsonConfig对象
        JsonConfig config=new JsonConfig();
        //设置循环策略为忽略 解决json最头疼的问题 死循环
        config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        //设置 json转换的处理器 用来处理日期类型
        //凡是反序列化Date类型的对象，都会经过该处理器进行处理
        config.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {
            //参数1 ：属性名 参数2：json对象的值 参数3：jsonConfig对象
            public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date d=(Date) arg1;
                return sdf.format(d);
            }
            public Object processArrayValue(Object arg0, JsonConfig arg1) {
                return null;
            }
        });
        String s=JSONObject.fromObject(cls,config).toString();
        System.out.println(s);
	}

}

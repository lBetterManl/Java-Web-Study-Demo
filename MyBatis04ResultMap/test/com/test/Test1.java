package com.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.entity.Order;
import com.util.MyBatisUtil;
/**
 * 执行单元测试的结果：
 * 1、testGetOrderById方法执行查询后返回一个null。
 *　2、testGetOrderById2方法和testGetOrderById3方法执行查询后可以正常得到想要的结果。
 *
 *　下面的测试代码演示当实体类中的属性名和表中的字段名不一致时，使用MyBatis进行查询操作时无法查询出相应的结果的问题以及针对问题采用的两种办法：
 *解决办法一: 通过在查询的sql语句中定义字段名的别名，让字段名的别名和实体类的属性名一致，这样就可以表的字段名和实体类的属性名一一对应上了，这种方式是通过在sql语句中定义别名来解决字段名和属性名的映射关系的。
 *解决办法二: 通过<resultMap>来映射字段名和实体类属性名的一一对应关系。这种方式是使用MyBatis提供的解决方式来解决字段名和属性名的映射关系的。
 */
public class Test1 {

	
	@Test
    public void testGetOrderById(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        /**
         * 映射sql的标识字符串，
         * com.mapping.orderMapper是orderMapper.xml文件中mapper标签的namespace属性的值，
         * getOrderById是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.mapping.orderMapper.getOrderById";//映射sql的标识字符串
        //执行查询操作，将查询结果自动封装成Order对象返回
        Order order = sqlSession.selectOne(statement,1);//查询orders表中id为1的记录
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(order);//打印结果：null，也就是没有查询出相应的记录
    }
    
    @Test
    public void testGetOrderById2(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        /**
         * 映射sql的标识字符串，
         * com.mapping.orderMapper是orderMapper.xml文件中mapper标签的namespace属性的值，
         * selectOrder是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.mapping.orderMapper.selectOrder";//映射sql的标识字符串
        //执行查询操作，将查询结果自动封装成Order对象返回
        Order order = sqlSession.selectOne(statement,1);//查询orders表中id为1的记录
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(order);//打印结果：Order [id=1, orderNo=aaaa, price=23.0]
    }
    
    @Test
    public void testGetOrderById3(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        /**
         * 映射sql的标识字符串，
         * com.mapping.orderMapper是orderMapper.xml文件中mapper标签的namespace属性的值，
         * selectOrderResultMap是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "com.mapping.orderMapper.selectOrderResultMap";//映射sql的标识字符串
        //执行查询操作，将查询结果自动封装成Order对象返回
        Order order = sqlSession.selectOne(statement,1);//查询orders表中id为1的记录
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
        System.out.println(order);//打印结果：Order [id=1, orderNo=aaaa, price=23.0]
    }
}

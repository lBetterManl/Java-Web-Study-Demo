package com.yhc.pagehelper;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

/**
 * 拦截查询SQL，根据分页对象自动设置分页数
 * @author YHC
 *
 */
@Intercepts(value = { @Signature(method = "prepare", args = { Connection.class }, type = StatementHandler.class) })
public class PageInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		 RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
	        BoundSql boundSql = handler.getBoundSql();
	        Object obj = boundSql.getParameterObject();

		if (obj == null)
			return invocation.proceed();

		Page page = null;
		if (obj instanceof Page) {
			page = (Page) obj;
		} else if (obj instanceof Map) {
			// 如果Dao中有多个参数，则分页的注解参数名必须是page
			try {
				page = (Page) ((Map) obj).get("page");
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}

		// 不存在分页对象，则忽略下面的分页逻辑
		if (page == null)
			return invocation.proceed();

		// 查询总记录数
		setTotalSize(handler.getParameterHandler(), boundSql,
				(Connection) invocation.getArgs()[0], page);

		// 获取最终执行的sql字段，方面下面重新设置值
		Field field = BoundSql.class.getDeclaredField("sql");
		field.setAccessible(true);

		// 查询的页面不能小于0
		if (page.getPageNum() <= 0)
			page.setPageNum(1);
		// 查询的页面不能超过最大页码
		if (page.getPageNum() > page.getTotalPage())
			page.setPageNum(page.getTotalPage());

		// 设置分页的SQL代码
		field.set(
				boundSql,
				boundSql.getSql() + " limit " + (page.getPageNum() - 1)
						* page.getPageSize() + ", " + page.getPageSize());

		return invocation.proceed();
	}

	
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub

	}
	
	private void setTotalSize(ParameterHandler parameterHandler,
			BoundSql boundSql, Connection conn, Page page) {
		String countSql = "select count(1) from (" + boundSql.getSql() + ") t";
		 
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(countSql);
            parameterHandler.setParameters(pstmt);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                // 设置总记录数
                page.setTotalSize(rs.getInt(1));
                System.out.println(page.getTotalPage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

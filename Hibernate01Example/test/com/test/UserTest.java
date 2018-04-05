package com.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class UserTest {
	//创建数据库表
	@Test
	public void CreateTab() {
		Configuration cfg = new Configuration().configure();
		SchemaExport export = new SchemaExport(cfg);
		export.create(true, true);
	}
}

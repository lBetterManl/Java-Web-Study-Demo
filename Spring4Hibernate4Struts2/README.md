##Spring4 Hibernate4 Struts2 三大框架整合

1.加入Spring

	1).加入jar包
	2).配置web.xml文件
	3).加入Spring的配置文件

2.加入Hibernate

	1).同时建立持久化类，和其对应的 .hbm.xml文件，生成对应的数据表
	2).Spring整合Hibernate
	3). 步骤:
		①. 加入 jar 包
		②. 在类路径下加入 hibernate.cfg.xml 文件, 在其中配置 hibernate 的基本属性
		③. 建立持久化类, 和其对应的 .hbm.xml 文件
		④. 和 Spring 进行整合
		i.  加入 c3p0 和 MySQL 的驱动
		ii. 在 Spring 的配置文件中配置: 数据源, SessionFactory, 声明式事务	
		⑤. 启动项目, 会看到生成对应的数据表

3.加入Struts2

	1). 加入 jar 包: 若有重复的 jar 包, 则需要删除版本较低的. javassist-3.11.0.GA.jar
	2). 在 web.xml 文件中配置 Struts2 的 Filter
	3). 加入 Struts2 的配置文件
	4). 整合 Spring
		①. 加入 Struts2 的 Spring 插件的 jar 包
		②. 在 Spring 的配置文件中正常配置 Action, 注意 Action 的 scope 为 prototype
		③. 在 Struts2 的配置文件中配置 Action 时, class 属性指向该 Action 在 IOC 中的 id

4.完成功能
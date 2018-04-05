1.Spring 整合Hibernate 整合什么？  
>
1).由 IOC 容器来管理 Hibernate 的SessionFactory  
2).让 Hibernate 使用上Spring 的声明式事务

2.整合步骤 : 
>
1).加入 hibernate4.2.4  
①.jar包  required  
②.添加hibernate的配置文件 hibernate.cfg.xml   
③ 编写持久化类对应的 .hbm.xml 文件  
2).加入spring4.2.5   
 ①.jar包  required  
 ②.加入spring 的配置文件    
3).整合  

3.实际编写代码

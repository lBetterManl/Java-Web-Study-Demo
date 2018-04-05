## List中contain() 方法的使用  

> 判断list中是否包含某个对象  

** 注意： **  

	1. User 类中必须改写equals(Object obj) 方法  	
	public boolean equals(Object obj){
		if(!(obj instanceof User))return false;
		User u = (User)obj;
		return this.name.equals(u.getName());
	}
	2. 若list中存在某个user则移除此对象
	User user = new User("u2", 2);
	if(userList.contains(user)){
		userList.remove(user);
	}
	
** 个人理解：**  

	上述User 类中的equals(Object obj) 方法  
	其中return 语句是根据User的name属性为主键来判断对象是否存在的  
	

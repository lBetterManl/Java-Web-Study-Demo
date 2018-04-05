package com.yhc.hibernate.dao;

public interface BookDao {
	
	//根据书号查询价格
	public int findBookPriceByIsbn(String isbn);
	
	//根据书号更改库存
	public void updateBookStock(String isbn);
	
	//更新用户的账户余额: 使 username 的 balance - price
	public void updateUserAccount(String username, int price);
}

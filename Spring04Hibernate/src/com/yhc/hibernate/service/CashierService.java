package com.yhc.hibernate.service;

import java.util.List;

/**
 * 出纳员 审查
 * @author YHC
 *
 */
public interface CashierService {

	public void checkout(String username, List<String> isbns);
}

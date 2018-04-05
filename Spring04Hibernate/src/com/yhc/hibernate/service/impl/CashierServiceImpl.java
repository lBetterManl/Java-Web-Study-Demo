package com.yhc.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhc.hibernate.service.BookService;
import com.yhc.hibernate.service.CashierService;
@Service
public class CashierServiceImpl implements CashierService {

	@Autowired
	private BookService bookService;
	
	@Override
	public void checkout(String username, List<String> isbns) {

		for(String isbn:isbns){
			bookService.purchase(username, isbn);
		}

	}

}

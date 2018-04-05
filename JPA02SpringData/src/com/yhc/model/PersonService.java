package com.yhc.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月8日 下午4:24:15
 */

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Transactional
	public void savePersons(List<Person> persons){
		personRepository.save(persons);
	}
	
	@Transactional
	public void updatePersonEmail(Integer id, String email){
		personRepository.updatePersonEmail(id, email);
	}
}

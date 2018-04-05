package com.yhc.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.yhc.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	//开启二级缓存
	@QueryHints({@QueryHint(name=org.hibernate.ejb.QueryHints.HINT_CACHEABLE,value="true")})
	@Query("FROM Department d")
	List<Department> getAll();
	
}

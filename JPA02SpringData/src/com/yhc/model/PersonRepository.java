package com.yhc.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月8日 下午2:36:41
 * 
 * 1. Repository是一个空接口，即使一个标记接口 2. 若我们定义的接口继承了Repository，则该接口会被IOC
 * 容器识别为一个Repository Bean 纳入到IOC 容器中，进而可以在该接口中定义满足一定规范的方法
 * 
 * 3. 实际上也可以通过@RepositoryDefinition 注解来替代继承Repository<Person, Integer>
 * 接口
 *
 * 在 Repository 子接口中声明方法
 * 1. 不是随便声明的. 而需要符合一定的规范
 * 2. 查询方法以 find | read |get 开头
 * 3. 涉及条件查询时，条件的属性用条件关键字连接 
 * 4. 要注意的是：条件属性以首字母大写。 
 * 5. 支持属性的级联查询.
 * 若当前类有符合条件的属性, 则优先使用, 而不使用级联属性. 若需要使用级联属性, 则属性之间使用 _
 * 进行连接,即Address_Id.
 */
/**
 * Repository 原始接口
 * CrudRepository 增删改查的接口  继承上面
 * PagingAndSortingRepository 分页排序的接口   继承上面
 * JpaRepository 继承上面
 * JpaSpecificationExecutor 用于带查询条件分页
 */
//@RepositoryDefinition(domainClass = Person.class, idClass = Integer.class)
public interface PersonRepository extends JpaRepository<Person, Integer>, JpaSpecificationExecutor<Person>, PersonDao {

	// 根据lastName查找Person
	Person getByLastName(String lastNane);

	// WHERE lastName LIKE ?% AND id < ?
	List<Person> getByLastNameStartingWithAndIdLessThan(String lastNane, Integer id);

	// WHERE lastName LIKE %? AND id < ?
	List<Person> getByLastNameEndingWithAndIdLessThan(String lastName, Integer id);

	// WHERE email IN (?,?) OR birth < ?
	List<Person> getByEmailInOrBirthLessThan(List<String> emails, Date birth);

	// WHERE a.id > ?
	List<Person> getByAddressIdGreaterThan(Integer id);

	// 以上是使用关键字，现在使用Query注解

	// 1. 查询id 值最大的那个Person
	// 使用@Query 注解可以自定义JPQL 语句以实现更灵活的查询
	@Query("SELECT p FROM Person p WHERE p.id = (SELECT max(p2.id) FROM Person p2 )")
	Person getMaxIdPerson();

	// 为@Query 传递参数的方式1：使用占位符(方法参数的位置必须按顺序放置)
	@Query("SELECT p FROM Person p WHERE p.lastName = ?1 AND p.email = ?2")
	List<Person> testQueryAnnotationParams1(String lastName, String email);

	// 为@Query 传递参数的方式2：使用命名参数(方法参数的位置可以随便放置)
	@Query("SELECT p FROM Person p WHERE p.lastName = :lastName AND p.email = :email")
	List<Person> testQueryAnnotationParams2(@Param("lastName") String lastName,
			@Param("email") String email);

	// SpringData 允许在占位符上添加%%
	@Query("SELECT p FROM Person p WHERE p.lastName LIKE %?1% OR p.email LIKE %?2%")
	List<Person> testQueryAnnotationLikeParam(String lastName, String email);

	// SpringData 允许在占位符上添加%%
	@Query("SELECT p FROM Person p WHERE p.lastName LIKE %:lastName% OR p.email LIKE %:email%")
	List<Person> testQueryAnnotationLikeParam2(@Param("lastName") String lastName, @Param("email") String email);
	
	//设置nativeQuery=true 即可使用原生的sql 查询
	@Query(value="SELECT count(id) FROM jpa_persons", nativeQuery=true)
	long getTotalCount();
	
	//可以通过JPQL 完成UPDATE 和 DELETE 操作。注意：JPQL不支持试用INSERT操作
	//在@Query 注解中编写JPQL 语句，但必须使用@Modifying 进行修饰，以通知SpringData，只是一个UPDATE 或DELETE操作
	//UPDATE 或 DELETE 操作需要使用事务，此时需要定义Service 层，在Service层的方法上添加事务操作
	//默认情况下，SpringData的每个方法上有事务，但都只是只读事务，他们不能完成修改操作！
	@Modifying
	@Query("UPDATE Person p SET p.email = :email WHERE p.id = :id")
	void updatePersonEmail(@Param("id") Integer id, @Param("email") String email);
}

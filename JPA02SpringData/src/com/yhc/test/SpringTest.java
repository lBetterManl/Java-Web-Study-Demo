package com.yhc.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;

import com.yhc.model.Person;
import com.yhc.model.PersonRepository;
import com.yhc.model.PersonService;

/**
 * @author YHC
 * @email yhc8023tm@foxmail.com
 * @version 2016年8月8日 下午2:38:37
 */
public class SpringTest {

	private ApplicationContext ctx = null;
	private PersonRepository personRepository = null;
	private PersonService personService;

	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		personRepository = ctx.getBean(PersonRepository.class);
		personService = ctx.getBean(PersonService.class);
	}
	
	//自定义Repository
	@Test
	public void testCustomeRepository(){
		personRepository.test();
	}

	// 目标： 实现带查询条件的分页。id>5的条件
	// 调用JpaSpecificationExecutor 的Page<T> findAll(Specification<T> spec,
	// Pageable pageable)
	// Specification: 封装了JPA Criteria 查询的查询条件
	// Pageable：封装了请求分页的信息：例如pageNo，pageSize，Sort
	@Test
	public void testJpaSpecificationExecutor() {
		int pageNo = 3;
		int pageSize = 5;
		PageRequest pagable = new PageRequest(pageNo, pageSize);

		// 通常使用Specification 的匿名内部类
		Specification<Person> specification = new Specification<Person>() {

			/**
			 * @param root:
			 *            代表查询的实体类
			 * @param query:
			 *            可以从中得到Root对象，即告知JPA Criteria 要查询哪一个实体类，还可以
			 *            来添加查询条件，还可以结合EntityManager 对象得到最终查询的TypedQuery 对象
			 * @param *cb:
			 *            CriteriaBuilder 对象用于创建Criteria
			 *            相关对象的工厂，当然可以从中获取到Predicate对象
			 * @return: *Predicate 类型，代表一个查询条件
			 */
			@Override
			public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				Path path = root.get("id");
				Predicate predicate = cb.gt(path, 5);
				return predicate;
			}
		};

		Page<Person> page = personRepository.findAll(specification, pagable);
		
		// 总的记录数
		System.out.println("总记录数：" + page.getTotalElements());
		// 当前第几页
		System.out.println("当前第几页：" + (page.getNumber() + 1));
		// 总页数
		System.out.println("总页数：" + page.getTotalPages());
		// 当前页面的list
		System.out.println("当前页面的list：" + page.getContent());
		// 当前页面的记录数
		System.out.println("当前页面的记录数：" + page.getNumberOfElements());
	}

	@Test
	public void testJpaRepository() {
		Person person = new Person();
		person.setBirth(new Date());
		person.setEmail("yhc@qq.com");
		person.setLastName("yhc");

		personRepository.saveAndFlush(person);
	}

	@Test
	public void testPagingAndSortingRepository() {
		// pageNo从0开始
		int pageNo = 3;// 当前是第pageNo+1页
		int pageSize = 5;
		// Pageable 接口通常使用其PageRequest 实现类，其中封装了需要分页的信息
		// 排序相关的.Sort封装了排序的信息
		// Order 是具体针对某一个属性进行升序还是降序
		Order order1 = new Order(Direction.DESC, "id");
		Order order2 = new Order(Direction.ASC, "email");
		Sort sort = new Sort(order1, order2);

		PageRequest pageRequest = new PageRequest(pageNo, pageSize, sort);
		Page<Person> page = personRepository.findAll(pageRequest);

		// 总的记录数
		System.out.println("总记录数：" + page.getTotalElements());
		// 当前第几页
		System.out.println("当前第几页：" + (page.getNumber() + 1));
		// 总页数
		System.out.println("总页数：" + page.getTotalPages());
		// 当前页面的list
		System.out.println("当前页面的list：" + page.getContent());
		// 当前页面的记录数
		System.out.println("当前页面的记录数：" + page.getNumberOfElements());
	}

	@Test
	public void testCrudRepository() {
		List<Person> persons = new ArrayList<>();
		for (int i = 'a'; i <= 'z'; i++) {
			Person person = new Person();
			person.setBirth(new Date());
			person.setEmail((char) i + "" + (char) i + "@qq.com");
			person.setLastName((char) i + "" + (char) i);
			persons.add(person);
		}
		personService.savePersons(persons);
	}

	@Test
	public void testModifying() {
		personService.updatePersonEmail(1, "nanshen@163.com");
	}

	// 得到id 最大的Person
	@Test
	public void testQueryAnnotation() {
		Person person = personRepository.getMaxIdPerson();
		System.out.println(person);
	}

	// 级联查询
	@Test
	public void testKeyWords2() {
		List<Person> persons = personRepository.getByAddressIdGreaterThan(1);
		System.out.println(persons);
	}

	// 查询lastName以？开头并且id<？的Person
	@Test
	public void testKeyWords() {
		List<Person> persons = personRepository.getByLastNameStartingWithAndIdLessThan("AA", 10);
		System.out.println(persons);

		persons = personRepository
				.getByEmailInOrBirthLessThan(Arrays.asList("123@qq.com", "234@qq.com"), new Date());

		System.out.println(persons.size());
	}

	@Test
	public void helloworld() {
		Person person = personRepository.getByLastName("AA");
		System.out.println(person);
	}
}

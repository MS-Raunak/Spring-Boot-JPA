package com.ms.springbootjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ms.springbootjpa.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
		/**
		 * CrudRepository provide inbuilt methods for following
		 * findById();
		 * findAllById();
		 * deleteById();
		 * updateById();
		 * etc..
		 * 
		 * We can also create custom method by following inbuilt method signature patterns as given below following
		 * findByName
		 * findByNameAndCity etc..
		 * Note:- I follows camel case approach to writing method name
		 * 
		 * We can also create custom method without following inbuilt method signature patterns as given below following
		 * getAllUser
		 *  etc..
		 * Note:- In case of custom pattern, we have to use jpql query or native query
		 */
	
	//custom finder method or derived query method with inbuilt method signature pattern
	public List<User> findByName(String name);
	public User findByNameAndCity(String name, String City);
	
	//custom finder method method with custom method signature pattern
		//1.Using JPQL query
		@Query("select u from User u")
		public List<User> getAllUser();
		
		@Query("select u from User u where name=:n and city=:c") 
		public User getUser(@Param("n") String name, @Param("c") String city);
		
		//2.Using native query
		@Query(value = "select * from User", nativeQuery = true )
		public List<User> getUsers();
}

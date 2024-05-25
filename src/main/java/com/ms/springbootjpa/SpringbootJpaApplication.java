package com.ms.springbootjpa;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.ms.springbootjpa.entities.User;
import com.ms.springbootjpa.repository.UserRepository;

@SpringBootApplication
public class SpringbootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbootJpaApplication.class, args);

		UserRepository repository = context.getBean(UserRepository.class);

		User user = new User();

		user.setName("Ronu");
		user.setCity("Bengaluru");
		user.setMobno("8876324421");

		User user2 = new User();

		user2.setName("Raunak");
		user2.setCity("Banglore");
		user2.setMobno("8876324421");

		User user3 = new User();

		user3.setName("MS");
		user3.setCity("Bengaluru");
		user3.setMobno("8876324421");

		/*########## Saving single user#############*/
		/*	User user1 = repository.save(user);
			 System.out.println(user1);*/

		/*######### Saving multiple users###############*/
		 /*
			List<User> users = List.of(user, user2, user3);
			repository.saveAll(users);
		
			users.forEach(usr->{
				System.out.println(usr);
			}); */
		
		
		/*########## Updating user by id ############# */
		  /*Optional<User> optional =  repository.findById(3);
		  User usr = optional.get();
		  usr.setName("Chhaya");
		  
		  User u = repository.save(usr);
		  System.out.println(u);*/
		
		/*########## Get single user data by id ############# */
		  /* Optional<User> usr = repository.findById(1);
		 System.out.println(usr);*/
		 
		 /*########## Get all user data ############# */
		  //Regular approach
		 /* 
		  List<User> users = (List<User>) repository.findAll(); 
		  Iterator<User> iterator = itr.iterator();
		
		  while(iterator.hasNext()) {
			  User usr = iterator.next();
			  System.out.println(usr);
		  }*/
		  
		  //JDK8 approach
		   /*Iterable<User> itr = repository.findAll();
		   itr.forEach(usr-> System.out.println(usr)); */
		 
		  
		/*########## Delete user by id ############# */
		 /*repository.deleteById(3);
		 System.out.println("user deleted");*/
		
		/*########## Delete user by obj (NOT RECOMMENDDED) ############# */
		 /*repository.delete(user2);
		 System.out.println("user deleted");*/
		
		/*########## Delete all users ############# */
		 /*Iterable<User> users = repository.findAll();
		 repository.deleteAll(users);
		 System.out.println("All user deleted");*/
		
		
		/*######## Get data using custom methods but inbuilt method signature pattern ##############*/
		//get user data by name
		 /*List<User> users = repository.findByName("Ronu");
		 users.forEach(usr-> System.out.println(usr));*/
		
		//get user data by name and city
		 /*User usr = repository.findByNameAndCity("Ronu", "Bengaluru");
		 System.out.println(usr);*/
		

		/*######## Get data using custom methods but custom method signature pattern ##############*/
		  repository.getAllUser().forEach(usr-> System.out.println(usr));
		  System.out.println("-------------------------------------------------------");
		  System.out.println(repository.getUser("Ronu", "Bengaluru"));
		  System.out.println("--------------------------------------------------------");
		  repository.getUsers().forEach(usr-> System.out.println(usr));
	}

}

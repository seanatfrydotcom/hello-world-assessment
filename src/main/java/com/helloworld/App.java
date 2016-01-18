package com.helloworld;

import java.util.Date;
import java.util.List;

import com.helloworld.model.User;
import com.helloworld.service.UserService;

public class App {

	public static void main(String[] args) {

		UserService userService=new UserService();
		User user1=new User("John","Doe","1 Some St","Apt 1","Some City","MI","48238","US",new Date());
		User user2=new User("Jane","Doe","2 Some St","Some City","OH","49121","US",new Date());
		User user3=new User("John","Smith","3 Any St","Some City","IN","42238","US",new Date());
		System.out.println("*** Persist - start ***");
		userService.save(user1);
		userService.save(user2);
		userService.save(user3);
		List<User> users1=userService.findAll();
		System.out.println("Users Persisted are :");
		for (User u : users1) {
			System.out.println("-" + u);
		}
		System.out.println("*** Persist - end ***");
		/*
		System.out.println("*** Update - start ***");
		user1.setCity("Detroit");
		userService.update(user1);
		System.out.println("User Updated is =>"+userService.findById(user1.getId()));
		System.out.println("*** Update - end ***");
		System.out.println("*** Find - start ***");
		Long id1=user1.getId();
		User another=userService.findById(id1);
		System.out.println("User found with id " + id1 + " is =>" + another.toString());
		System.out.println("*** Find - end ***");
		System.out.println("*** Delete - start ***");
		Long id3=user3.getId();
		userService.delete(user3);
		System.out.println("Deleted user with id " + id3 + ".");
		System.out.println("Now all users are " + userService.findAll().size() + ".");
		System.out.println("*** Delete - end ***");
		System.out.println("*** FindAll - start ***");
		List<User> users2=userService.findAll();
		System.out.println("Users found are :");
		for (User u : users2) {
			System.out.println("-" + u.toString());
		}
		System.out.println("*** FindAll - end ***");
		System.out.println("*** DeleteAll - start ***");
		userService.deleteAll();
		System.out.println("Books found are now " + userService.findAll().size());
		System.out.println("*** DeleteAll - end ***");
		*/
		System.exit(0);
	}

}

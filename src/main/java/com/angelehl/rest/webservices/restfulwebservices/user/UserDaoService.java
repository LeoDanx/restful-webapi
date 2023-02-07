package com.angelehl.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
		
	private static List<User> users = new ArrayList<>();
	private static int usersCount=0;
	
	static {
		users.add(new User(++usersCount,"Adam",LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount,"Eve",LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount,"Jim",LocalDate.now().minusYears(20)));
	}
	
	
	public List<User> findAll(){
		
		return users;
	}
	
	public User findUser(int id){
		
		//return users.get(id-1);
	//	return users.stream()
	//			.filter(x-> x.getId().equals(id)).findFirst().get();
		return users.stream()
				.filter(x -> x.getId().equals(id)).findFirst().orElse(null);
	}
	
	public User createUser(User user){
		
		user.setId(++usersCount);
		users.add(user);
		
		return user;
		
	}
}

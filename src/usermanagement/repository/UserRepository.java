package usermanagement.repository;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.GsonBuilder;

import usermanagement.entity.User;
import usermanagement.service.UserService;



public class UserRepository {
	
	private List<User> userDataList;  
	
	private static UserRepository instance;
	
	public static UserRepository getInstance() {
		if(instance == null) {
			instance = new UserRepository();
		}
		return instance;
	}
	
	private UserRepository() {
		userDataList = new ArrayList<>();
	}
	
	public void saveUser(User user) {
		userDataList.add(user);

		
	}
	
	public User findeUserByUsername(String username) {
		User user = null;
		
		for(User u : userDataList) {
			if(u.getUsername().equals(username)) {
				user = u;
				break;
			}
			
		}
		return user;
		
	}

}

package usermanagement.service;

import java.util.HashMap;

import java.util.Map;
import java.util.Map.Entry;

import org.mindrot.jbcrypt.BCrypt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import usermanagement.entity.User;
import usermanagement.repository.UserRepository;

public class UserService {
	
	private final UserRepository userRepository;
	private Gson gson;
	
	public static UserService instance;
	
	public static UserService getInstance() {
		if(instance == null) {
			instance = new UserService();
		}
		return instance;
	}
	
	
	private UserService() {
		userRepository = UserRepository.getInstance();
		gson = new GsonBuilder().setPrettyPrinting().create();
		
	}
	
	public Map<String, String> register(String userJson) {
		// response: 응답
		Map<String, String> response = new HashMap<>();
		
		Map<String, String> userMap = gson.fromJson(userJson, Map.class);
		for(Entry<String, String> userEntry : userMap.entrySet()) {
			
			// entry를 사용하는 이유
			// 현재 username, passworl, name, email을 json을 변경후 UserService에서 Map
			// 으로 변환하고 있다. 키와 밸류의 한 쌍은 Entry이다. entry에서 getKey()를 하면
			// 밸류를 가져온다. entrySet()을 통해중복되지 않도록 값을 넣고 꺼내온다.
			if(userEntry.getValue().isBlank()) {
				response.put("error", userEntry.getKey() + "은(는) 공백일 수 없습니다.");
				return response;
			}
		}
		
		
		User user = gson.fromJson(userJson, User.class);
		System.out.println("서비스에 넘어옴! User 객체로 변환");
		System.out.println(user);
		
		if(duplicatedUsername(user.getUsername())) {
			response.put("error", "이미 사용중인 닉네임");
			return response;
		}
		
		if(duplicatedEmail(user.getEmail())) {
			response.put("error", "이메일이 중복되었습니다.");
			return response;
		}
		
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		System.out.println("암호화 후");
		System.out.println(user);
		
		userRepository.saveUser(user);
		response.put("ok", "회원가입 성공.");
		
		return response;
		
	}
	
	private boolean duplicatedUsername(String username) {
		return userRepository.findeUserByUsername(username) != null;
	}
	
	private boolean duplicatedEmail(String email) {
		return userRepository.findeUserByEmail(email) != null;
	}
	
//	private boolean isBlank(User user) {
//		
//	}

}

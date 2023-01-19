package j20_json.builder;

import lombok.Builder;
import lombok.Data;


@Data
// builder 안에는 allArgsConstructor를 포함한다.

public class User {
	
	private String username;
	private String password;
	private String name;
	private String email;
	
	public static UserBuilder builder() {
		return new UserBuilder();
	}
	
	public User(String username2, String password2, String name2, String email2) {
		// TODO Auto-generated constructor stub
	}

	// static 클래스
	@Data
	public static class UserBuilder {
		private String username;
		private String password;
		private String name;
		private String email;
		
		public UserBuilder username(String username) {
			this.username = username;
			return this;
		}
		public UserBuilder password(String password) {
			this.password = password;
			return this;
		}
		public UserBuilder name(String name) {
			this.name = name;
			return this;
		}
		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}
		
		public User build() {
			return new User(username, password, name, email);
		}
	}

}

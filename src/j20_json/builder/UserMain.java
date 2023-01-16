package j20_json.builder;

public class UserMain {
	public static void main(String[] args) {
		//User user = new User();
		// static 사용시 User를 생성하지 않아도 생성이 가능하다.
		//User.UserBuilder  userBuilder = new User.UserBuilder();
		
		User user2 = User.builder()
				.username("aaa")
				.password("1234")
				.name("김준일")
				.build();
		
		System.out.println(user2);
	}
	

}

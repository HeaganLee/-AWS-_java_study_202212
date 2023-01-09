package j12_배열;

public class J12_UserMain {

	public static void main(String[] args) {
		J12_User[] users = new J12_User[0];
		// userRepository를 불러오기 위해서는 배열의 형태가 필요
		J12_UserRepository userRepository = new J12_UserRepository(users);
		J12_UserService service = new J12_UserService(userRepository);
		
		service.run();
		service.stop();
		
	}
	
}

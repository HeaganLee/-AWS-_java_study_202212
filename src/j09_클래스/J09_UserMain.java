package j09_클래스;

public class J09_UserMain {
	
	
	public static void main(String[] args) {
		J09_User user1 = new J09_User(); // 클래스를 구현 할 수 있는 모든 것 
		J09_User user2 = new J09_User(); // 변수, 생성자.. 모든 것을 객체라고 부르지만
		                                 // 대체로 인스턴스를 지칭하기로 약속
		
		user1.username = "aaa";
		user1.passworld = "1234";
		user1.name = "김종환";
		user1.email = "aaa@gmail.com";
		
		user2.username = "bbb";
		user2.passworld = "5678";
		user2.name = "이해강";
		user2.email = "bbb@gmail.com";
		
		user1.printUserInfo();
		System.out.println();
		user2.printUserInfo();
		System.out.println();
		
		
		
		
		
		
		
	}

}

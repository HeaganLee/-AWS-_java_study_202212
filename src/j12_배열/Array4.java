package j12_배열;

public class Array4 {
	
	public static void main(String[] args) {
		J12_User[] users = new J12_User[3];
		
		J12_User[] users2 = new J12_User[] {
				new J12_User("aaa", "1234", "김", "aaa@gmail.com"),
				new J12_User("bbb", "1234", "김", "aaa@gmail.com"),
				new J12_User("ccc", "1234", "김", "aaa@gmail.com")
				
		};
		
		J12_User[] users3 = {
				new J12_User("aaa", "1234", "김", "aaa@gmail.com"),
				new J12_User("bbb", "1234", "김종환", "aaa@gmail.com"),
				new J12_User("ccc", "1234", "김종환", "aaa@gmail.com")
				};
		
		users[0] = new J12_User("aaa", "1234", "김", "aaa@gmail.com");
		users[1] = new J12_User("bbb", "1234", "김", "aaa@gmail.com");
		users[2] = new J12_User("ccc", "1234", "김", "aaa@gmail.com");
		
		for(int i = 0; i < users.length; i++) {
			
			System.out.println(users[i].toString());
		}
	}

}

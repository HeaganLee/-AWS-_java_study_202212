package j19_컬렉션;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class User {
	private String username;
	private String name;
}

public class ArrayUserMain {
	
	public static void main(String[] args) {
		
		User [] userArray = {
				new User("aaa", "김종환"),
				new User("bbb", "고병수"),
				new User("ccc", "손민재"),
				new User("ddd", "황창욱"),
				
		};
		
		List<User> userList = Arrays.asList(userArray);
		
		Scanner scanner = new Scanner(System.in);
		String serachUsername = null;
		boolean flag = true;
		
		System.out.print("username 검색: ");
		serachUsername = scanner.nextLine();
		
		
		System.out.println("강사님 ver");
		User user = serachUser(userList, serachUsername);
		
		if(user == null) {
			System.out.println("검색실패!");
			System.out.println("존재하지 않는 계정");
		} else {
			System.out.println("검색성공");
			System.out.println(serachUsername + "계정의 회원 이름은 " +user.getName() + "입니다.");
		}
		
		System.out.println("나 ver");
		for(int i = 0; i < userList.size(); i++) {
			if(userList.get(i).getUsername().equals(serachUsername)) {
				System.out.println("검색성공! " + userList.get(i).getUsername() + "계정의 회원 이름은  " + userList.get(i).getName() + "입니다." );
				flag = false;
				break;
			}
		}
		
		if(flag) {
			System.out.println("검색실패! 존재하지 않는 계정입니다.");
		}
		
	}
	
	// 널이면 검색 실패 널이 아니면 user 반환
	private static User serachUser(List<User> userList, String username) {
		User user = null;
		
		for(User u : userList) {
			if(u.getUsername().equals(username)) {
				user = u;
				break;
			}
		}
		
		return user;
	}

}

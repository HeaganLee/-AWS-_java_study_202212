package j12_배열;

// Entity(정보를 담는다, 주로 자료형으로 사용)
// 기능을 담당하면 서비스 클래스(Main)
public class J12_User {
	private String username; 	// 사용자이름(아이디, 계정)
	private String password; 	// 비밀번호
	private String name;		// 성명
	private String email;		// 이메일

	public J12_User() {}		// ctrl + space 

	// alt + shift + s constructor and using filed
	public J12_User(String username, String password, String name, String email) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	// alt + shift + s getter and setter
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	// toString을 호출하게 되면 String을 리턴
	public String toString() {
		return "J12_User [username=" + username + ", password=" + password + ", name=" + name + ", email=" + email
				+ "]";
	}
	
	
	
	
	
	
}

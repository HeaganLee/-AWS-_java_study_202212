package j09_클래스;

public class J09_Student {
	
	String name = "김";
	int age = 100;
	// 기본 값으로 설정이 되면 바꾸지 않는 한 계속 찍어짐
	
	// 기본 생성자
	J09_Student() {
		// 클래스에는 생략
		System.out.println("생성됨!!!!");
	}
	
	void printInfo() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}

}

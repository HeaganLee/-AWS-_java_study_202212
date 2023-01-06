package j11_접근지정자.default1;

// public을 없애면 다른 패키에 사용 불가
public class J11_StudentDefault {
	
	private String name; // 데이터의 은닉 외부로 부터 데이터를 사용하지 못 하게 하는 것
	private int age;
	
	public J11_StudentDefault() {
		
		
	}
	
	public J11_StudentDefault(String name, int age) {
		this.name = name;
		this.age = age;
		
	}
	
	public void printInfo() {
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
	}
	
	// Getter: 값을 가져오는 것
	// ${name} 호출 ->name을 가지고 있는 카멜표기법 변수 가져오기
	public String getName() {
		return name;
	}
	
	// Setter: 값을 넣는 것
	public void setName(String name) {
		this.name = name;
	}
	
	
}

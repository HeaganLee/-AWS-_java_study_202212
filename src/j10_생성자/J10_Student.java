package j10_생성자;

public class J10_Student {
	// 기본 생성자는 생략이 되어있음
	// 생성자의 오버로딩이 일어나면 
	// 기본생성자는 생략되는 것이 비활성화 됨
	// 기본생성자까지 사용하려면 기본 생성자를 만들어 주어야 한다.
	
	String name;// 항상 default 상태 동일 패키지 클래스 만 가능
	int age;// 참조변수, 래퍼런스 변수, 멤버변수
	        // 메소드도 참조 메소드, 래퍼런스 메소드, 멤버 메소드라 불림
	        // 지역변수는 매개변수랑 별개로 침
	
	// required argument 생성자는 메개변수가 final이어야 한다.
	// no argument
	J10_Student(){
		System.out.println("기본 출력");
		
	}
	J10_Student(int age){
		System.out.println("학생의 나이: " + age);
		
	}
	
	J10_Student(String name) {
		System.out.println("학생의 이름: " + name);
	}
	
	// this를 이용하는 이유: 생성하는 시점에서 데이터를 입력을 하기 위해서
	J10_Student(String name, int age){
		this.name = name;// 항상 변수명을 바꾸 수는 없으니 this를 사용
		this.age = age; // this를 사용을 통해 멤버변수로 
		System.out.println(name);
		System.out.println(age);
	}
	
	void printInfo() {
		System.out.println("학생의 이름: " + name);
		System.out.println("학생의 나이: " + age);
	}
}

package j08_메소드;
// 똑같은 메소드 이름을 쓸수 있는 조건
// 매개변수의 조건이 다르면 사용가능
// 이유: 호출하는 시점에서 정해지기에 가능
// 그리고 이것을 오버로딩(오버로드)라고 한다.
// 비교대상 오버라이딩(덮어쓰기): 기존에 있는 것을 재정의
public class Method3 {
	
	public static void ov1() {
		System.out.println("매개변수 없음");
	}
	
	public static void ov1(int a) {
		System.out.println("int 매개변수 하나");
	}
	
	public static void ov1 (int a, int b) {
		System.out.println("int 먼저 그 다음은 String");
	}
	
	public static void ov1(String a, int b) {
		System.out.println("String 먼저 그다음 int");
	}

	public static void main(String[] args) {
		ov1();
		ov1(10);
		ov1(10, 20);
		ov1("사람", 2);
		
	}
}

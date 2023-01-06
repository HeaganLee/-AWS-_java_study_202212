package j08_메소드;
// 메소드: 클래스 안에 있는 함수
// 함수: 클래스 밖에 있는 함수
// 단, Java는 클래스 안에서만 가능하기에 메소드 밖에 없다.
public class Method2 {
	
	// 매개변수: x, 반환: x
	// 호이스팅: 정의된 함수를 먼저 분석
	// 정의를 시켜 준 후 출력이 됨
	public static void method1() {
		System.out.println("단순 실행");
	}
	
	// 매개변수: int 하나 입력, 반환: x
	public static void method2(int num) {
		System.out.println("num: " + num);
		System.out.println();
	}
	
	// 매개변수: int 두개 입력, 반환: x
	public static void method3(int num, int num2) {
		System.out.println("num: " + num);
		System.out.println("num2: " + num2);
		System.out.println();
	}
	
	public static String method4() {
		return "데이터 반환";
	}
	
	public static String method5(int age) {
		return age + "살";
	}

	public static void main(String[] args) {
		method1(); // 함수 호출
		method2(100);
		method3(200, 300);
		
		System.out.println(method4());
		System.out.println();
		
		String data1 = method4();
		System.out.println(data1);
		System.out.println();
		
	    System.out.println(method5(30));
	    System.out.println();
	}
	
}

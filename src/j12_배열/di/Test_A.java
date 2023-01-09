package j12_배열.di;

public class Test_A {
	// 상태가 절대 변하지 말아야 하는 것은 final 걸어줌 상수로 만듬
	private final Test_B tb;
	
	// 생성자가 호출이 되지 않더라도 정의가 되지 않음
	//1. 생성자를 통한 호출
	public Test_A(Test_B tb) {
		// 의존성을 띄고 있음 dependency 높음 ==> 결합도가 높음
		// A가 생성이 되어야지 B가 생성
		this.tb = tb;
	}
	//2. set을 통한 할당
	// final 선언시 set을 사용 못함
//	public void setTb(Test_B tb) {
//		this.tb = tb;
//	}
	
	public void testA1() {
		System.out.println("테스트A1 메소드 호출!!");
		//Test_B tb = new Test_B();
		
		tb.testB1();
	}
	
	public void testA2() {
		System.out.println("테스트A2 메소드 호출!!");
		//Test_B tb = new Test_B();
		
		tb.testB1();
	}

}

package j13_상속;

public class KiaCar extends Car {
	
	public KiaCar() {
		// super의 생성자 호출
		super(); 
		System.out.println("자식");
		
		// super();는 밑으로 가면 안됨 부모 객체가 먼저 생성이 되어야
		// 하기 때문
	}
	
	@Override
	// 생략이 되어져 있는 상태
	public int discountPrice(int percentage) {
		return super.discountPrice(percentage);
	}
	
	
	
	public void test() {
//		// 자기 자신 주소를 대입
//		// 자기 자신을 주로를 변수에 대입하고 싶을 때
//		KiaCar kc = this;
//	}
	

}
}

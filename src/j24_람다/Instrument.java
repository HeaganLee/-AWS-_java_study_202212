package j24_람다;

// 무조건 람다형이다.
// 다른 메소드가 생기지 못하도록 해줌
@FunctionalInterface
public interface Instrument {
	
	public String play(String instrument);
	
	// 단 default 메소드는 여러개라도 상관이 없다.
	// 왜냐? 구현된 메소드이기 때문이다.
	public default void testPring() {
		System.out.println("테스트");
	}
	

}

package j22_익명클래스;

public class Main {

	public static void main(String[] args) {
		Calculator c1 = new Addition();
		System.out.println(c1.calc(10, 20));
		
	////////////////////////////////////////////////////////////////////////////////////////////////
		
		// 인터페이스를 구현한 클래스로 익명클래스라고 부른다.
		// 다른 곳에 못씀 클래스 파일로 저장이 안되어 있기 때문에 
		// 일회성이다.
		Calculator c2 = new Calculator() {
			
			@Override
			public int calc(int x, int y) {

				return x - y;
			}
			
		};
		System.out.println(c2.calc(200, 100));
	}
}

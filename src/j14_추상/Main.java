package j14_추상;

// 추상클래스는 일반적인 생성이 안 됨
public class Main {
	
	// 일반적인 생성은 안 된다
	public static void main(String[] args) {
		Transpotation transpotation = new Airplane();
		Transpotation transpotation1 = new Taxi();
	}

}

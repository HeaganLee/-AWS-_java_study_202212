package j15_인터페이스;

public interface Calculator {
	
	// 상수선언은 대문자, final 생략 가능 
	public int ERROR = -9999999;
		
	// 인터페이스 안에는 abstract를 제외 하고 사용가능
	// {} 사용 불가하여 생성이 불가
 	public double plus(double x, double y);
 	
	public double minus(double x, double y);
	
	// default를 사용해야 일반적인 메소드가 됨
	// 일반변수를 가지지 못함
	// 상수는 가짐
	public default double multiplication(double x, double y) {
		return x * y;
	}
	
	public double division(double x, double y);

}

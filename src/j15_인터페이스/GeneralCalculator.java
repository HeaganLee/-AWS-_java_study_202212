package j15_인터페이스;

// 자바는 단일 상속 extends는 하나의 클래스에만 가능
// 단, 인터페이스는 도구로서 여러개가 가능하다.

public class GeneralCalculator extends Equipment implements Calculator {

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("일반 계산기 전원을 켭니다.");
		
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("일반 계산기 전원을 끕니다.");
		
	}

	@Override
	public double plus(double x, double y) {
		System.out.println("일반계산기에서 덧셈을 실행");
		return x + y;
	}

	@Override
	public double minus(double x, double y) {
		System.out.println("일반계산기에서 빼기 실행");
		return x - y;
	}
	
	@Override
	public double division(double x, double y) {
		System.out.println("일반계산기에서 나누기 실행");
		
		if(x == 0 || y == 0) {
			return ERROR;
		}
		
		return x / y;
	}
	

}

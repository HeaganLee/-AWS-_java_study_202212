package j24_람다;

// 추상메소드를 단 하나만 가지고 있는 인터페이스만 람다로 사용이 가능하다.
public class Lambda1 {

	private String gitar = "기타";
	public static void main(String[] args) {
		
		// 변수 없이 독립적으로 사용이 가능
		Instrument instrument = new Instrument() {
			@Override
			public String play(String instrument) {
				
				return instrument + "을(를) 연주합니다.";
			}
		};
		
		// 독립적으로 사용이 불가
		Instrument instrument2 = (String itm) -> {
			return instrument + "을(를) 연주합니다.";
		};
		
		// 매개변수의 자료형을 생략할 수 있다.
		// 매개변수의 이름을 바꿀 수 있다.
		Instrument instrument3 = (itm) -> {
			return instrument + "을(를) 연주합니다.";
		};
		
		// 매개변수가 하나이면 매개변수를 감싸는 괄호를 생략할 수 있다.
		Instrument instrument4 = itm -> {
			return instrument + "을(를) 연주합니다.";
		};
		
		// 구현부의 명령이 하나일 때 중괄호를 생략할 수 있다.
		// 이떄 리턴자료형이 정해저있으면 리턴값으로 사용이 된다.
		// 중괄호를  지우면 return은 사라져야 한다.
		Instrument instrument5 = itm -> instrument + "을(를) 연주합니다.";
		
		int result = 10 + 20;
		// 매개변수를 사용이 불가
		Instrument instrument6 = itm -> instrument + "을(를) 연주합니다." + result;
		
		/*
		 * 람다를 사용하는 이유
		 * 1. main 메소드에서 사용하는 지역변수를 사용가능
		 * 2. 간결해진다.
		 * 3. 일회성으로 사용이 가능하다.
		 * */
		
		/*
		 * 람다 단점
		 * 1. 여러개의 메소드를 가지고 있는 인터페이스는 사용이 불가
		 */
		
		
		
		System.out.println(instrument2.play("드럼"));
		System.out.println(instrument.play("피아노"));
		System.out.println(instrument6.play("기타"));
	}
}

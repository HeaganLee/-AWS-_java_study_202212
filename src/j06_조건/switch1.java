package j06_조건;

public class switch1 {
	
	public static void main(String[] args) {
		
		String select = "A선택";
		
		switch (select) {
			case "A선택" :
				System.out.println("A PC를 연결합니다.");
				break;
			case "B선택" :
				System.out.println("B PC를 연결합니다.");
				break;
			case "C선택" :
				System.out.println("C PC를 연결합니다.");
				break;
			case "D선택" :
				System.out.println("D PC를 연결합니다.");
				break;
			default :
				System.out.println("else와 같은 역할");
		}
	}

}

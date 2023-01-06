package j02_변수;

public class Variable2 {

	public static void main(String[] args) {
		char firstName1 = '가';
		char firstName2 = '일';
		
		char alphabetA = '준';
		
		System.out.println("김"+firstName1+firstName2);
		System.out.println("알파벳A: "+alphabetA);
		
		System.out.println(alphabetA+'B');
		System.out.println("\uAC00");
		System.out.println(firstName1+0);
		
		
		
		
		int a = 15; // 10진수
		int b = 015; // 8진수
		int c = 0x15; // 16진수
		int d = 0b0101; // 2진수
		long e = 26L; // long은 L을 붙임
		
		double i = 0.1234d; // double에 d를 붙어야 함 
		double f = 0.1234; // 생략 가능
		
		float h = 0.1234f; // float는 f를 반드시 붙어야 함

	}

}

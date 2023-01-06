package j11_접근지정자;

import j11_접근지정자.default1.J11_StudentDefault; // 다른 패키지면 무조건 적으로 import 해주어야함 

public class J11_StudentMain {

	public static void main(String[] args) {
		J11_Student s1 = new J11_Student("해강", 30);
		
		s1.printInfo();
		
		J11_StudentDefault s2 = new J11_StudentDefault();
		
		
		System.out.println("이름: " + s2.getName());
		
		
		
	}
}

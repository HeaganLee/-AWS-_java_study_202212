package j09_클래스;

public class J09_StudentMain {
	

	public static void main(String[] args) {
		
		
		
//		J09_Student student1 = new J09_Student();
//		J09_Student/*자료형*/ student2/*변수명(힙에의 주소를 받는 곳)*/ = new/*키워드*/ J09_Student();/*값이자 생성자 주소를 대입*/
		// 주소를 찍어주는 행위를 참조라고 하고 참조행위라고 한다.
		// 생성자 호출시 new 필수!!
		// 생성자는 클래스명과 일치, 단 형태는 메소드 형태
		
//		System.out.println(student1);
//		System.out.println(student2);
		
		J09_Student s1 = new J09_Student();
		J09_Student s2 = new J09_Student();
		J09_UserMain u1 = new J09_UserMain();
		
		s1.name = "김준일";
		s1.age = 30;
		
		s1.printInfo();
		s2.printInfo();
		// 메소드 안에서는 초기화를 해야하지만
		// 클래스 안에는 초기화를 하지 않아도 기본 값으로 가능
		
		
		}

}

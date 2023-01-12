package j16_object;

// Object는 최상위 클래스
// Object는 무조건적으로 상속받는다.
// 그렇기에 Object에 있는 메소드인 equals finalize hash toString을 오버라이드 가능하다.
public class ToString {
	
	public static void main(String[] args) {
		
		// student1에는 주소가 들어가 있어
		// String str = student1는 안됨
		 Student student1 = new Student("조병철", 34);
		 Student student2 = new Student("김동민", 28);
		 Student student3 = new Student("김두영", 28);
		 Student student4 = new Student("강의진", 29);
		 
		 System.out.println(student1);
		 System.out.println(student2);
		 System.out.println(student3);
		 System.out.println(student4);
		 
		 System.out.println();
		 
		 System.out.println(student1.toString());  //위 결과값과 같음.
		 System.out.println(student2.toString());
		 System.out.println(student3.toString());
		 System.out.println(student4.toString());
	}

}

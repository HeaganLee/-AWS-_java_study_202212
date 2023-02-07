package j17_스태틱.싱글톤;

public class A {
	
	
	private static A instance = null;
	
	private Student[] students;
	
	// A를 아무대서나 생성하지 못하게 하기 위해
	private A() {
		students = new Student[3];
	}
	
	// 딱하나만 새성하기 위해
	public static A getInstance(){
		if(instance == null) {
			instance = new A();
		}
		return instance; 
	}
	
	
	
	public void addStudent(Student student) {
		
		for(int i = 0; i < students.length; i++) {
			if(students[i] == null) {
				students[i] = student;
				// return을 사용하는 것으로 for문을 잠시 멈추고 students[i]에 대입하고 반환
				return;
			}
		}
		
		System.out.println("더 이상 학생을 추가할 수 없습니다.");
		System.out.println();
	}
	
	public void showStudents() {
		for(Student student : students) {
			// 만약 toString을 사용하게 되면 null주소값은 참조를 하지 못하기에
			// 오류가 난다.
			System.out.println(student);
		}
			System.out.println();
	}
	
}

package j17_스태틱;

public class StudentMain {
	// toString은 생략 가능
	// 단 객체를 String 변수에 대입을 할 때는 toString으로 바꿩야 한다.
	public static void main(String[] args) {
		System.out.println(Student.getAutoUncrement());
		Student[] students = new Student[5];
		Teacher[] teahchers = new Teacher[5];
		
		students[0] = new Student("이현수");
		students[1] = new Student("김재영");
		students[2] = new Student("이상현");
		students[3] = new Student("박성진");
		students[4] = new Student("윤성영");
		
		teahchers[0] = new Teacher("김준일1");
		teahchers[1] = new Teacher("김준일2");
		teahchers[2] = new Teacher("김준일3");
		teahchers[3] = new Teacher("김준일4");
		teahchers[4] = new Teacher("김준일5");
		
//		Student s = new Student("김준일");
//		System.out.println(s);
		
		// for반복문
		for(int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
			System.out.println(teahchers[i]);
			System.out.println();
		}
		System.out.println();
		
		// 이렇게 쓰면 변수낭비
		int j = 0;
		// for each문
		for (Student s1 : students) {
			System.out.println(s1);
			System.out.println(teahchers[j]);
			System.out.println();
			j++;
		}
		
		System.out.println(Student.getAutoUncrement());
	}
}

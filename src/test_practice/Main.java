package test_practice;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1001, "홍길동"));
		students.add(null);
		students.add(new Student(1003, "김영희"));
		
		
	
		
		try {
			for(Student student : students) {
				student.showStudent();
			}
		}catch (NullPointerException e) {
			students.set(1, new Student(1002, "강철수"));
		}
		
		students.get(1).showStudent();
		students.get(2).showStudent();
		
		
		
 	}
}

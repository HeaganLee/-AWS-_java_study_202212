package j19_컬렉션;

import java.util.ArrayList;
import java.util.List;

public class StudentArrayList {
	
	public static void updateYear(
			List<Student> students,
			String searchName,
			int newYear) {
		
		for(Student student : students) {
			if(student.getName().equals(searchName)) {
				student.setYear(newYear);
				return;
			}
		}
		
		System.out.println("검색실패!");
		
	}
	
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("김종환", 1));
		students.add(new Student("고병수", 2));
		students.add(new Student("손민재", 3));
		students.add(new Student("황창욱", 4));
		
		System.out.println(students);
		
		System.out.println(students.get(0).getYear());
		
		System.out.println();
		System.out.println("===========여기서부터 문제==========");
		
		// 비용이 2배듬
		String searchName = "이해강";
		int sum = 0;
		for(int i = 0; i < students.size(); i++) {
			if(searchName == students.get(i).getName()) {
				students.get(i).setYear(4);
				System.out.println(students.get(i).getName() + "학생의 학년은 " + students.get(i).getYear());
				break;
			}else {
				sum +=1;
			}
			
			if(sum == students.size()) {
				System.out.println("검색실패");
			}
		}
		
		System.out.println("====강사님 풀이====");
		System.out.println();
		
		// 비용이 반복 횟수만큼
		boolean flag = true;
		for(int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
			if(student.getName().equals(searchName)) {
				student.setYear(4);
				flag = false;
				break;
			}
		}
		
		System.out.println("for each문");
		for(Student student : students) {
			if(student.getName().equals(searchName)) {
				student.setYear(4);
				flag = false;
				break;
			}
		}
		
		if(flag) {
			System.out.println("검색 실패!!!");
		}
		
		System.out.println(students);
		
		updateYear(students, "김준일", 1);
		System.out.println(students);
		
	}

}

package j10_생성자;

public class J10_StudentMain {
	
	public static void main(String[] args) {
		
		
		J10_Student s1 = new J10_Student();// 1. 기본생성자
		J10_Student s2 = new J10_Student(30); // 2. 나이만 할당
		J10_Student s3 = new J10_Student("루피"); // 3. 이름만 할당
		
		J10_Student s4 = new J10_Student("루피",4);
		
		
		
	}

}

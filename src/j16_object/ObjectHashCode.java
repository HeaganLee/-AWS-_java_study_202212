package j16_object;

public class ObjectHashCode {
	
	public static void main(String[] args) {
		Student s1 = new Student("김수현", 31);
		Student s2 = new Student("김수현", 31);
		SubStudent s3 = new SubStudent("김수현",31);
		
		// 해쉬값 주소값 안에 밸류가 같아 똑같이 나옴
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		// 해시코드는 객체가 달라도 해시코도만 같으면 된다.
		// equals는 객체가 다르면 다른 것이다.
		System.out.println(s1.hashCode() == s2.hashCode());
		System.out.println(s1.hashCode() == s3.hashCode());
		
	}
}

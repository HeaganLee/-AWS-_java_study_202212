package j16_object;

import java.util.Objects;

public class Student {
	
	private String name;
	private int age;
	
	
	public Student(String name, int age) {
		super();   //부모클래스 생성자 호출. 부모는 Object 클래스. Object클래스는 최상위클래스. 만들어진 클래스는 항상 오브젝트클래스를 상속받는다.
		this.name = name;
		this.age = age;
	}
	
	@Override
	// 해시코드 값으로 적용 된다.
	// 문자열이면 문자열 숫자면 숫자 대로 나누어서 코드로 만듬
	// 해시코드 값으로도 비교를 할 수 있다.
	public int hashCode() {
		return Objects.hash(name, age);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(!(obj.getClass() == Student.class)) {
			return false;
		}
		
		Student s = (Student) obj;
		boolean result = name.equals(s.name) && age == s.age;
		
		
		return result;
	}
	
	@Override
	public String toString() {
		return "이름: " + name + "\n나이: " + age;
	}
	
}

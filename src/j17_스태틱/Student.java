package j17_스태틱;

public class Student {
	
	private static final int CODE = 20230000;
	private static int ai = 1; //auto_increment
	
	private int studentCode;
	private String name;
	
	public Student(String name) {
		studentCode = CODE + ai;
		ai++;
		this.name = name;
		
	}
	
	// static은 생성을 하지 않아도 사용할 수 있는 메소드이다
	// 그렇기에 생성을 하여야지만 사용이 가능한 변수는 사용이 가능하지 않다.
	// 단, 지역변수는 가능
	public static int getAutoUncrement() {
		System.out.println("현재 AI: " + ai);
		// System.out.println("학생이름: " + name);
		return ai;
	}

	@Override
	public String toString() {
		return "Student [studentCode=" + studentCode + ", name=" + name + "]";
	}
	
	

}

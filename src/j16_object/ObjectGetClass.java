package j16_object;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectGetClass {
	
	public static void main(String[] args) {
		Student student = new Student("김재영", 29);
		
		// 정확하게 클래스명을 명시
		// 정확하게 클래스명을 비교를 할 떄 필요
		// instanceof는 상속시에 문제가 생김
		System.out.println(student.getClass());
		System.out.println(Student.class);
		
		System.out.println(student.getClass().getName());
		
		Class studentClass = student.getClass();
		
		// 어느 패키지의 클래스 이름
		String className = studentClass.getName();
		System.out.println("클래스 이름: " + className);
		
		// 클래스 이름만
		String simpleName = studentClass.getSimpleName();
		System.out.println("클래스 이름만: " + simpleName);
		
		// 필드배열
		// 어디 안에 있는지
		Field[] fields = studentClass.getDeclaredFields();
		for(Field field : fields) {
			System.out.println(field);
		}
		
		System.out.println();
		
		// 해당 클래스의 메소드의 배열
		Method[] methods = studentClass.getDeclaredMethods();
		for(Method method : methods) {
			System.out.println(method);
		}
		
	}

}

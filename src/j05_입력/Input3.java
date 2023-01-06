package j05_입력;

import java.util.Scanner;

public class Input3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String name = null;
		int age = 0;
		String address = null;
		String phonenumber = null;
		
		
		System.out.print("이름: ");
		name = scanner.next();
		
		System.out.print("나이: ");
		age = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("주소: ");
		address = scanner.nextLine();
		// next는 enter은 입력이 되지 않는다. 단, nextLine()은 인식하기에 enter로 입력되어 빈 공간이 발생
		// 그렇기에 nextLine() 전에 허공에 날려주어야 한다.
		
		/*버퍼에서의 문제로 "주소: 연략처:" 아 같은 형상 일어남
		원인: Scanner.nextInt() 메소드가 사용자가 입력한 enter(개행문자) 를 제거하지 않기 때문이다.
		사용자는 콘솔창에 숫자입력 후 enter를 누르는데,
		이때 nextInt() 가 숫자는 입력받고, 개행문자는 제거하지않은 채 그대로 남겨둔다.
		남겨진 개행문자가 다음 scan.nextLine() 의 입력으로 처리되어
		곧바로 개행되고, 위와같이 출력된다.*/
		
		System.out.print("연락처: ");
		phonenumber = scanner.next();
		
		System.out.println("사용자의 이름은 " + name + "이고 " + "나이는 " + age + "살입니다.\n"
				+ "주소는 " + address + "에 거주중입니다.\n"
				+ "연락처는 " + phonenumber + " 입니다.");
		
		
	}
}

package j05_입력;

import java.util.Scanner;

// ctrl + shift + o(작성이 완료된 상태) or Scanner 입력 후 ctrl + space(미완성 시)

public class Input2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("문자열1: ");
		String str1 = scanner.nextLine();// 띄어쓰기 허용
		
		System.out.print("문자열2: "); // 띄어쓰기 허용 x 그렇기에 띄어쓰기를 하면 다음 입력창에 영향이 감
		String str2 = scanner.next();
		
		System.out.print("정수: ");
		int number1 = scanner.nextInt();
		
		System.out.print("실수: ");
		double number2 = scanner.nextDouble();
		
		System.out.println("문자열1: " + str1);
		System.out.println("문자열2: " + str2);
		System.out.println("정수: " + number1);
		System.out.println("실수: " + number2);
		
		
		
}
}

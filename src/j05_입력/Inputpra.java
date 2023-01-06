package j05_입력;

import java.util.Scanner;

import org.xml.sax.SAXNotRecognizedException;

public class Inputpra {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = 0;
		char c = 0;
		long l = 0;
		double d = 0;
		boolean b;
		
		System.out.print("숫자 입력: ");
		num = scanner.nextInt();
		System.out.print("문자 입력: ");
		c = scanner.next().charAt(c);
		System.out.print("long 입력: ");
		l = scanner.nextLong();
		System.out.print("double 입력: ");
		d = scanner.nextDouble();
		System.out.print("boolean 입력: ");
		b = scanner.nextBoolean();
		
		System.out.println("숫자는: " + num + "문자는: " + c + " 롱은: " + l + " 실수: " + d );
		
		
		
}
}

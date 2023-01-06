package j05_입력;

import java.util.Scanner;

// ctrl + shift + o(작성이 완료된 상태) or Scanner 입력 후 ctrl + space(미완성 시)

public class Input1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int inputNum = 0; 
		int inputNum2 = 0;
		int inputNum3 = 0;
		int inputNum4 = 0;
		int inputNum5 = 0;
		
		System.out.print("입력1: ");
		inputNum = scanner.nextInt();
		System.out.print("입력2: ");
		inputNum2 = scanner.nextInt();
		System.out.print("입력3: ");
		inputNum3 = scanner.nextInt();
		System.out.print("입력4: ");
		inputNum4 = scanner.nextInt();
		System.out.print("입력5: ");
		inputNum5 = scanner.nextInt();
		
		System.out.println("입력값: " +(inputNum + inputNum2 + inputNum3 + inputNum4 + inputNum5));
		
		
}
}

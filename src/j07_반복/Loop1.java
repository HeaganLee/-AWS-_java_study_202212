package j07_반복;

import java.util.Scanner;

public class Loop1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int total = 0;// 반복 종료 후 전부 더한 값
		
		System.out.print("반복횟수: ");
		count = scanner.nextInt();
		System.out.println();// 한 줄 공백 만들기
		
		for (int i = 0; i < count; i++) {
			 int a = 0;
			 int b = 0;
			 int sum = 0;// 반복 할 때 마다 더한 값
			
			System.out.println((i + 1) +"번 반복");
			System.out.print("a: ");
			a = scanner.nextInt();
			System.out.print("b: ");
			b = scanner.nextInt();
			
			sum = a + b;
			total += sum;
			
			System.out.println((i + 1) + "번 합: " + sum + "\n");
			
		}
		System.out.println("총합: " + total);
		
	}
}

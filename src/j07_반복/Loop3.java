package j07_반복;

import java.util.Scanner;

public class Loop3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int total = 0;
		int startNumber = 0;
		int endNumber = 0;
		
		System.out.print("시작: ");
		startNumber = scanner.nextInt();
		System.out.print("끝: ");
		endNumber = scanner.nextInt();
		
		for (int i = 0; i < endNumber - startNumber+1; i++) {
			total += i + startNumber;
		}
		System.out.println("총합: " + total);
		
		
	}
}

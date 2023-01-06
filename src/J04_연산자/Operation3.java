package J04_연산자;

/*
 * 논리 연산자
 * 
 * AND(곱) T && T = T, T && F = F
 * 
 * OR(합) T || T = T, T || F = T
 * 
 * NOT(부정) !T = F, !F = T
 * 
 */

public class Operation3 {
	public static void main(String[] args) {
		int num = 11;
		
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = num % 2 == 0;
		
		System.out.println(flag1 && flag2);
		System.out.println(flag1 && flag3);
		System.out.println(!(flag2 || flag3 && flag1));
		
		
	}
}

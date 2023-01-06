package j06_조건;

import java.util.Scanner;

public class Conditional2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int score = 0;
		String grade = null;
		
		System.out.print("성적 점수 입력: ");
		score = scanner.nextInt();
		
		if(score > 100 || score < 0 ) {
			grade = null;
		} else if(score > 94) {
			grade = "A+";
			//System.out.println("점수(" + score + ")" + grade + "학점");
		} else if(score > 89) {
			grade = "A";
			//System.out.println("점수(" + score + ")" + grade + "학점");
		} else if (score > 84) {
			grade = "B+";
			//System.out.println("점수(" + score + ")" + grade + "학점");
		} else if (score > 79) {
			grade = "B";
			//System.out.println("점수(" + score + ")" + grade + "학점");
		} else if (score > 74) {
			grade = "C+";
			//System.out.println("점수(" + score + ")" + grade + "학점");
		} else if (score > 69) {
			grade = "C";
			//System.out.println("점수(" + score + ")" + grade + "학점");
		} else if (score > 64) {
			grade = "D+";
			//System.out.println("점수(" + score + ")" + grade + "학점");
		} else if (score > 59) {
			grade = "D";
			//System.out.println("점수(" + score + ")" + grade + "학점");
		} else {
			grade = "F";
		}// 등급을 무여하는 용도
		
		if ((score >59 && score < 101) && (score % 10 > 4 || score == 100)) {
			grade += "+";
		}// 플러스 용도
		
		if (grade == null) {
			System.out.println("계산 불가");
		}else {
			System.out.println("점수(" + score + ")" + grade + "학점");
		}// 출력 용도
		
		// 응집도를 위해서
		
		   
	}

}

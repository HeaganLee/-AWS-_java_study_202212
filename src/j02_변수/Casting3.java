package j02_변수;

public class Casting3 {

	public static void main(String[] args) {
		double kor = 87.5;
		double eng = 95.7;
		double math = 80.5;
		
		int total = 0;
		double avg = 0;
		total = (int) kor + (int) eng + (int) math;
		avg = total / 3.0;
		
		System.out.println("총합은 " + total + "이고 " + "평균은 " +avg+ "입니다.");
		
		
		
		
		

	}

}

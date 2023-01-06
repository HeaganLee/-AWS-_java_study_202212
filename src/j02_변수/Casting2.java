package j02_변수;

public class Casting2 {

	public static void main(String[] args) {
		char char_a = 'a';
		int num =char_a;// 업케스팅은 자동으로 케스팅 됨!!(묵시적 형변환)
		
		char char_b =(char)(num+1); //다운케스팅시 꼭 명시!!
		
		System.out.println(char_b);
	}

}

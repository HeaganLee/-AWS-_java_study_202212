package j07_반복;

public class Continue {

	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			
			if(i % 2 != 0) {
				continue; // 다음 반복을 계속해라
			}
			
			System.out.println("i: " + i);
			
		}
		int k = 0;
		
		while(k < 10) {
			
			
			if (k % 2 != 0) {
				k++;
				continue;
			}
			
			
			System.out.println("k: " + k);
			k++;
			
		}
	}
}

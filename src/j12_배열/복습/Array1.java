package j12_배열.복습;

public class Array1 {
	
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int num4 = 40;
		int num5 = 50;
		
		int[] nums = new int[5];
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		nums[3] = 40;
		nums[4] = 50;
		
		// 대입하는 개수를 보고 메모리 갯수를 정함
		
		int[] nums1 = new int[] {10, 20, 30, 40, 50};
		
		// 이것 자체로 값이다.(배열의 주소가 나옴)
		System.out.println(new int[] {10, 20, 30, 40, 50});
	}

}

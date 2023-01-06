package j12_배열;

public class Array1 {

	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int num4 = 40;
		int num5 = 50;
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(num5);

		int [] nums = new int[5]; // 배열은 참조 자료형, new가 들어가면 모든지 참조
		// 배열을 쓰는 근본적인 이유는 반복문을 사용하기 위해서이다.
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		nums[3] = 40;
		nums[4] = 50;
		
		for (int i = 0; i < 5; i++) {
			System.out.println(nums[i]);
		}
	}

}

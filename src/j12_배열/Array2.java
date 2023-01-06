package j12_배열;

public class Array2 {
	
	public static void printNames(String[] names) {
		for (int i = 0; i < names.length; i++) {
		System.out.println("이름[" + (i + 1) + "] " + names[i]);
		
		} 
		System.out.println();
	}

	public static void main(String[] args) {
		
		// 들어갈 값이 정해져 있을 때 공간이 확실 할 때
		String[] names = new String[3];
		
		names[0] = "김상훈";
		names[1] = "임나영";
		names[2] = "김종환";
		
		// 배열을 생성과 동시에 넣기
		// 공간이 확실 할 때
		// 매개변수를 쓸 때
		String[] names2 = new String[] {"이상현", "손지호", "이강용"};
		
		// 배열로 설정시 new String[] 필요
		// 단 다른 곳에서는 배열로 인정하지 않음
		String[] names3 = {"김두영", "강대협", "이현수", "김재명"};
		
		
		printNames(names);
		printNames(new String[] {"이상현", "손지호", "이강용"});
		printNames(names3);
		for (int i = 0; i < 3; i++) {
			System.out.println("이름: " + names[i]);
		}
		
		int [] a = new int[5];
		
		int [] b = new int[] {1,2,3};
		
		System.out.println(b[1]);
		
		
		
		
	}

}

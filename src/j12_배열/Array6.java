package j12_배열;

public class Array6 {
	
	public static void main(String[] args) {
		
		String[] names = {"박성진", "조병철", "황창욱"};
		
		for(String name : names) {
			System.out.println(name);
			name = "김준일";
		}
		
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);

		}
		
		int [] a = {1,2,3,4,5};
		
		for (int i : a) {
			System.out.println("i: " + i);
		}
		
		
		
		// forEach는 처음부터 끝까지 하나씩 꺼낸다.
		// 앞쪽은 변수 선언 ':'의 뒤에는 배열이나 리스트
	}

}

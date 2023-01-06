package j12_배열;

public class Array5 {
	
	// 응집도가 높고 결합도가 낮은 코드가 좋은 코드이다.
	// a b c 가 있다면 a가 b와 c를만들어야 하며 a가 b를 b가 c를 생성하는 코드는 결합도가 높아 안 좋음 
	
	// 코드를 나눈 이유: 클린 코드(메소드명만으로 어떤 동작을 하는지 알 수 이어야 함)
	
	// 4. 기존 배열과 새로운 배열을 transferArray에 넣어주고 oldArray의 값을 newArray에 옮김
	// 주소를 사용하기에 return을 사용을 할 필요가 없다.
	
	public static void transferArray(int[] oldArray, int[] newArray) {
		for(int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
	}
	
	// 3. 기존의 배열에 +1를 하여 용량을 늘려주고 배열의 주소를 넣어줌
	public static int[] addArrayLength(int[] array) {
		int[] newArray;
		newArray = new int[array.length + 1];
		transferArray(array, newArray);
		return newArray;
		
	}
	
	// 2. 배열이랑 새로 추가한 데이터를 받음
	public static int[] addData(int[] array, int data) {
		int[] newArray = addArrayLength(array);
		newArray[array.length] = data;
		return newArray;
	}
	
	public static void main(String[] args) {
		
		int[] nums = new int[0]; // 1. 0개인 배열을 만듬
		
		nums = addData(nums, 1);
		nums = addData(nums, 2);
		nums = addData(nums, 3);
		nums = addData(nums, 4);
		nums = addData(nums, 5);
		
		addData(nums, 1);
		
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
		
		 
	}
}

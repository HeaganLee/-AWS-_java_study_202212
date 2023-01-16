package j20_json;

import com.google.gson.Gson;

public class Json3 {

	public static void main(String[] args) {
		// Gson이라는 라이브러리를 사용하고 싶을 때
		Gson gson = new Gson();
		
		// valueOf 문자열을 숫자로
		System.out.println(Integer.valueOf("100") + 50);
		System.out.println(Integer.parseInt("100") + 50);
		
		gson.toJson(null); 					// object 		-> json
		gson.fromJson("", Object.class);	// json			-> object
	}
}

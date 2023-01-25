package j19_컬렉션;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapStringMain {
	
	public static void main(String[] args) {
		
		// map은 키와 value가 있다.
		Map<String, String> strMap = new HashMap<>();
		
		strMap.put("이종현", "a");
		strMap.put("진채희", "b");
		strMap.put("김재영", "c");
		strMap.put("이상현", "a");
		
		System.out.println(strMap);
		
		System.out.println(strMap.get("a"));
		System.out.println(strMap.get("e"));
		
		for(String k : strMap.keySet()) {
			System.out.println("key: " + k);
			System.out.println(strMap.get(k));
		}
		
		
		// 키값으로 해쉬코드로 정렬로 하여 출력
		for(String v : strMap.values()) {
			System.out.println("value: " + v);
		}
		
		Set<Entry<String, String>> s = null;

		for(Entry<String, String> entry: strMap.entrySet()) {
			System.out.println("key: " + entry.getKey());
			System.out.println("value: " + entry.getValue());
			System.out.println();
		}
		
		System.out.println("============================================================");
		
		strMap.forEach((k, v) -> {
			System.out.println("key: " + k);
			System.out.println("value: " + v);
		});
	}

}

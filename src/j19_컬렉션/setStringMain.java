package j19_컬렉션;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class setStringMain {

	public static void main(String[] args) {
		// 애는 키값이 없다 그렇기에 for each문으로 꺼냄
		// Hash 값을 가지고 정렬
		// 중복이 안 됨 
		Set<String> setStr = new HashSet<>();
		List<String> listStr = new ArrayList<>();
		
		
		listStr.add("임나영");
		listStr.add("이강용");
		listStr.add("임나영");
		listStr.add("임나영");
		System.out.println("========List 출력========");
		System.out.println(listStr);
		
		setStr.add("김상현");
		setStr.add("강대협");
		setStr.add("손지호");
		setStr.add("최해혁");
		setStr.add("최해혁");
		setStr.addAll(listStr);
		
		System.out.println();
		System.out.println("========set 출력========");
		System.out.println(setStr);
		System.out.println();
	
		
		String searchName = "손지호";
		
		System.out.println("========for each문========");
		
		for (String name : setStr) {
			if(name.equals(searchName)) {
				System.out.println(name);
			}
		}
		System.out.println();
		System.out.println("=========Iterator 반복자========");
		// Iterator
		Iterator<String> iterator = setStr.iterator();
		while(iterator.hasNext()) {
			String n = iterator.next();
			if(n.equals(searchName)) {
				System.out.println(n);
			}
		}
		
	}
}

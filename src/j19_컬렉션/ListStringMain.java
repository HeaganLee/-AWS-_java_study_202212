package j19_컬렉션;

import java.util.ArrayList;
import java.util.List;

public class ListStringMain {

	public static void main(String[] args) {
		String[] strArray = new String[] {"java", "python", "C++"};
		
		String[] newStrArray = new String[strArray.length + 1];
		
		for(int i = 0; i < strArray.length; i++) {
			newStrArray[i] = strArray[i];
		}
		
		newStrArray[newStrArray.length - 1] = "html";
		
		
		System.out.println("[strArray]");
		for(String s : strArray) {
			System.out.println(s);
		}
		System.out.println();
		
		System.out.println("[newStrArray]");
		for(String s : newStrArray) {
			System.out.println(s);
		}
		
		
		
		new ArrayList<>().add("test");
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("java");
		strList.add("python");
		strList.add("python");
		strList.add("python");
		strList.add("python");
		strList.add("python");
		strList.add("python");
		strList.remove("java");
		strList.add(1, "java");
		strList.remove(1);
		
		System.out.println(strList.size());
		
		System.out.println();
		for(int i = 0; i < strList.size(); i++) {
			System.out.print("[" + i + "]: ");
			System.out.println(strList.get(i));
		}
		
		for(String str : strList) {
			System.out.println(str);
		}
		
		
			
	}
}

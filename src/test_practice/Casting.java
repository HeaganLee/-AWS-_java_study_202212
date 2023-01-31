package test_practice;

public class Casting {

	public static void main(String[] args) {
		Program[] programs = new Program[2];
		programs[0] = new Java();
		programs[1] = new C();
		
		for(int i = 0; i < programs.length; i++) {
			if(i == 0) {
				programs[i].develp();
				// 현재 Casting 클래스는 Program객체의 배열을 생성하였다.
				// Program 자체는 Java나 C 보다 상위 객체이지만 
				// Casting에서 Java와 C를 직접적으로 갈수는 없기에
				// Program를 거쳐서 가야한다.
				// 하지만 Program은 Java와 C의 상위이므로 다운 캐스티을 통해서만 사용이 가능
				((Java) programs[i]).garbageCollection();
			}else {
				programs[i].develp();
				((C) programs[i]).defineStructure(); 
			}
			
	
			
		}
		

	
	}

}

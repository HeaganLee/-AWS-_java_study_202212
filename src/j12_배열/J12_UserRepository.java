package j12_배열;

// 저장소, 데이터 관리
public class J12_UserRepository {
	
	// 
	private J12_User[] userTable;

	// 전체 생성자
	public J12_UserRepository(J12_User[] userTable) {
		super();
		this.userTable = userTable;
	}
	
	// setter를 만들면 안된다.
	// 이유 밖에서 마음대로 만들게 되면 꼬이기 때문이다.
	public J12_User[] getUserTable() {
		return userTable;
	}
	
	public void saveUser(J12_User user) {
		extendArrayOne();
		userTable[userTable.length - 1] = user;
	}
	
	// 여러명 등록
	private void extendArray(int length) {
		J12_User[] newArray = new J12_User[userTable.length + length];
		transferdataToNewArray(userTable, newArray);
		userTable = newArray;
	}
	
	// 한명씩 등록
	private void extendArrayOne() {
		J12_User[] newArray = new J12_User[userTable.length + 1];
		transferdataToNewArray(userTable, newArray);
		userTable = newArray;
	}
	
	private void transferdataToNewArray(J12_User[] oldArray, J12_User[] newArray) {
		for(int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
	}
	
	
	

	
}

package test_practice;

public class RoleMstMain {
	
	public static void main(String[] args) {
		RoleMst rolMst = RoleMst.bulider()
				.roleId(1)
				.roleName("ddd")
				.build();
		
		System.out.println(rolMst.toString());

		
	}

}

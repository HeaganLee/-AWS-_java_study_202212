package usermanagement.entity;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
	private int userId;
	private String username;
	private String password;
	private String name;
	private String email;
	
	//user mst에는 RoleDtl를 여러개 가지고 있다.
	private List <RoleDtl> roleDtls;
	
	

}

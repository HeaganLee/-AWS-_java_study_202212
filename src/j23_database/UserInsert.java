package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import j20_json.builder.User;

public class UserInsert {
	// DBConnectionMgr의 객체를 둔 pool 변수 생성
	private DBConnectionMgr pool;
	
	public UserInsert() {
		// DBConnectionMgr이 싱글톤이기에 getInstance를 통해서 객체를 생성
		pool = DBConnectionMgr.getInstance();
	}
	
	
	// user_mst 테이블에 데이터를 입력할 메소드인 saveUser 생성
	public int saveUser(User user) {
		// 성공 횟수를 세는 변수
		int successCount = 0;
		
		// DBConnectionMgr를 getInstance를 이용해 객체 생성
		DBConnectionMgr pool = DBConnectionMgr.getInstance();
		// insert를 역할 해줄 sql 변수 생성
		String sql = null;
		// mysql과 연동을 할 수 있게 해줌
		Connection connection = null;
		// SQL 구문을 실행하는 역할
		// Statement 클래스의 기능 향상
		//인자와 관련된 작업이 특화(매개변수)
		//코드 안정성 높음. 가독성 높음.
		//코드량이 증가 -> 매개변수를 set해줘야하기 때문에..
		//텍스트 SQL 호출
		PreparedStatement preparedStatement = null;
		//결과값을 저장할 수 있다.
		//저장된 값을 한 행 단위로 불러올 수 있다.
		//한 행에서 값을 가져올 때는 타입을 지정해 불러올 수 있다.
		ResultSet resultSet = null;
		
		// 연결과 sql문 입력은 예외가 많음으로 try~catch문 사용
		try {
			// MySql 연결
			connection = pool.getConnection();
			
			// 일일히 + '" 값 "' + 하면 귀찮기 때문에
			sql = "insert into user_mst\r\n"
					+ "values (0, ?, ?, ?, ?)";
			
			// preparedStatement는 하나의 텍스트문이다.
			// RETURN_GENERATEDE_KEYS는 AutoIncrement 키의 값을 가져오는데 사용이 되어진다.
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// setString(? 기준으로 순서, 가져올 값)
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setString(4, user.getEmail());
			
			// 몇개가 적용이 되었는지 확인
			successCount = preparedStatement.executeUpdate(); // insert, update, delete 명령 실행
			// 결과값
			resultSet = preparedStatement.getGeneratedKeys();
			
			// 여기서의 next는 값이 아니다.
			if(resultSet.next()) {
				System.out.println("이번에 만들어진 user_id Key 값: " + resultSet.getInt(1));
				// 이번에 만들어진 키 값을 넣는다.
				user.setUserId(resultSet.getInt(1));
				
			}
			// 예외 발생시 e.printStackTrace() 실행
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// successCount 리턴
		return successCount;
	}
	
	// role_dtl에 넣도록 하는 saveRoles 생성자를 만듬
	public int saveRoles(Map<String, Object> map) {
		int successCount = 0;
		
		
		
		String sql = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = pool.getConnection();
			// Map<String, Object> map = new HashMap<>()에서 roles키의 value를 가져와야 한다.
			// 하지만 Object 형태로서 현재 list의 형태로 대입이 되어 있기에 list로 다운 캐스팅을 시켜줌
			List<Integer> roles = (List<Integer>) map.get("roles");
			// user 키의 값을 다운캐스팅
			User user = (User) map.get("user");
			
			sql = "insert into role_dtl values";
			
			// 반복문을 돌려주는 이유는 현재 insert를 해야 되는 값이 2개이다 그렇기에 고정하기 보다 
			// 반복문을 통해 (0, ?, ?)를 필요할 때 마다 늘려준다.
			for(int i = 0; i < roles.size(); i++) {
				
				sql += "(0, ?, ?)";
				// 마지막에는 ,를 붙이면 안 되기에 방지 차원에서 해줌
				if(i < roles.size() - 1) {
					sql += ",";
				}
			}
			
			preparedStatement = connection.prepareStatement(sql);
			
			// 반복문을 통해 role_id와 user_id를 넣어준다.
			// 이 때 ?의 개수는 반복문을 통해서 늘어나기에 for문을 통해 순서를 자동적으로 늘어나게 해준다.
			for(int i = 0; i < roles.size(); i++) {
			preparedStatement.setInt((i * 2) + 1, roles.get(i));
			preparedStatement.setInt((i * 2) + 2, user.getUserId());
		}
		
			// 실행 시키기
		successCount = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return successCount;
	}

	public static void main(String[] args) {
		
		UserInsert userInsert = new UserInsert();
		
		
		
		User user = User.builder()
				.username("ddd")
				.password("1234")
				.name("ddd")
				.email("ddd@gmail.com")
				.build();
	
		int successCount = userInsert.saveUser(user);
		
		System.out.println("쿼리 실행 성공: " + successCount + "건");
		
		System.out.println(user);
		
		/*===========================================================================================*/
		
		
		List<Integer> roleIdList = new ArrayList<>();
		roleIdList.add(2);
		roleIdList.add(3);
		
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		map.put("roles", roleIdList);
		
		successCount = userInsert.saveRoles(map);
		
		System.out.println(map);
	}
	
	

}


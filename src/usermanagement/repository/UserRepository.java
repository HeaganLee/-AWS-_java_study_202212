package usermanagement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import usermanagement.config.DBConnectionMgr;
import usermanagement.entity.RoleDtl;
import usermanagement.entity.RoleMst;
import usermanagement.entity.User;

/*
 * UserDao
 * 접근하는 용도의 객체
 */
public class UserRepository {
	
	private static UserRepository instance;
	
	public static UserRepository getInstance() {
		if(instance == null) {
			instance = new UserRepository();
		}
		return instance;
	}
	
	
	private DBConnectionMgr pool;
	
	private UserRepository() {
		pool = DBConnectionMgr.getInstance();
	}

	
	public int saveUser(User user) {
		int successCount = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = pool.getConnection();
			String sql = "insert into user_mst values(0, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			
			successCount = pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				user.setUserId(rs.getInt(1));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return successCount;
	}
	
	public int saveRoleDtl(RoleDtl roleDtl) {
		// 성공횟수 변수설정
		int successCount = 0;
		// sql 구문 변수 설정
		String sql = null;
		// 연결 변수 설정
		Connection con = null;
		// 구문실행 변수 설정
		PreparedStatement pstmt = null;
		// 결과값 저장 변수 설정
		// 저장된 값을 한 행의 단위로 볼 수 있다.
		// 한 행에서 가져올때 타입을 지정 할 수 있다.
		
		
		// pool.getConnection()문은 예외가 많이 발생 함으로 try~catch문을 잡아준다.
		try {
			// my sql과 연결을 해준다(이 때 DBConnectionMgr에는 MySql의 chatting 스키마와 연결이 되어있음).
			con = pool.getConnection();
			// 지금 원하는 것은 rol_dtl에 값을 넣어주는 것임
			sql = "insert into role_dtl values(0, ?, ?)";
			// 구문 입력
			// sql에서 자동적으로 rol_dtl의 키 값을 자동으로 설정을 하기에 새로 생성된 키값을 가져와야 합니다.
			// 그 역할을 하는 것이 Statement.RETURN_GENERATED_KEYS 이다.
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, roleDtl.getRoleId());
			pstmt.setInt(2, roleDtl.getUserId());
			
			// 구문을 실행하고 성공 횟수를 카운트
			successCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		
		// 성공횟수를 리턴
		return successCount;
	}
	// 해당 유저를 찾아주는 용도
	public User findeUserByUsername(String username) {
		// 정보가 유저에 저장이 되어져 있기에 User 객체를 불러온다.
		User user = null;
		// 연결
		Connection con = null;
		// 구문
		PreparedStatement pstmt = null;
		// 결과
		ResultSet rs = null;
		
		try {
			// 연결을 시켜줌
			con = pool.getConnection();
			// sql에서 가져오고 싶은 값을 sql 구문으로 작성
			String sql = "select \r\n"
					+ "	   um.user_id,\r\n"
					+ "    um.username,\r\n"
					+ "    um.password,\r\n"
					+ "    um.name,\r\n"
					+ "    um.email,\r\n"
					+ "    rd.role_dtl_id,\r\n"
					+ "    rd.role_id,\r\n"
					+ "    rd.user_id,\r\n"
					+ "    rm.role_id,\r\n"
					+ "    rm.role_name\r\n"
					+ "from\r\n"
					+ "	   user_mst um\r\n"
					+ "	   left outer join role_dtl rd on(rd.user_id = um.user_id)\r\n"
					+ "    left outer join role_mst rm on(rm.role_id = rd.role_id)\r\n"
					+ "where \r\n"
					+ "	   username = ?";
			// preparedStatement를 통해 sql 구문 실행
			pstmt = con.prepareStatement(sql);
			//?가 username인 유저를 찾기
			pstmt.setString(1, username);
			
			rs = pstmt.executeQuery();
			
			List<RoleDtl> roleDtls = new ArrayList<>();
			int i = 0;
			while(rs.next()) {
				// i 가 0이면 User 객체를 생성해라
				if(i == 0) {
				user = User.builder()
						.userId(rs.getInt(1))
						.username(rs.getString(2))
						.password(rs.getString(3))
						.name(rs.getString(4))
						.email(rs.getString(5))
						.build();
				}
				RoleMst roleMst = RoleMst.builder()
						.roleId(rs.getInt(9))
						.roleName(rs.getString(10))
						.build();
				
				RoleDtl roleDtl = RoleDtl.builder()
						.roleDtlId(rs.getInt(6))
						.roleId(rs.getInt(7))
						.userId(rs.getInt(8))
						.roleMst(roleMst)
						.build();
				
				roleDtls.add(roleDtl);
				i++;
			}
			
			// 완성된 dtl를 user에 넣어줌
			if(user != null) {
				user.setRoleDtls(roleDtls);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return user;
	}
	
	public User findeUserByEmail(String email) {
		// 정보가 유저에 저장이 되어져 있기에 User 객체를 불러온다.
		User user = null;
		// 연결
		Connection con = null;
		// 구문
		PreparedStatement pstmt = null;
		// 결과
		ResultSet rs = null;
		
		try {
			// 연결을 시켜줌
			con = pool.getConnection();
			// sql에서 가져오고 싶은 값을 sql 구문으로 작성
			String sql = "select \r\n"
					+ "	   um.user_id,\r\n"
					+ "    um.username,\r\n"
					+ "    um.password,\r\n"
					+ "    um.name,\r\n"
					+ "    um.email,\r\n"
					+ "    rd.role_dtl_id,\r\n"
					+ "    rd.role_id,\r\n"
					+ "    rd.user_id,\r\n"
					+ "    rm.role_id,\r\n"
					+ "    rm.role_name\r\n"
					+ "from\r\n"
					+ "	   user_mst um\r\n"
					+ "	   left outer join role_dtl rd on(rd.user_id = um.user_id)\r\n"
					+ "    left outer join role_mst rm on(rm.role_id = rd.role_id)\r\n"
					+ "where \r\n"
					+ "	   username = ?";
			// preparedStatement를 통해 sql 구문 실행
			pstmt = con.prepareStatement(sql);
			//?가 username인 유저를 찾기
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			List<RoleDtl> roleDtls = new ArrayList<>();
			int i = 0;
			while(rs.next()) {
				// i 가 0이면 User 객체를 생성해라
				if(i == 0) {
				user = User.builder()
						.userId(rs.getInt(1))
						.username(rs.getString(2))
						.password(rs.getString(3))
						.name(rs.getString(4))
						.email(rs.getString(5))
						.build();
				}
				RoleMst roleMst = RoleMst.builder()
						.roleId(rs.getInt(9))
						.roleName(rs.getString(10))
						.build();
				
				RoleDtl roleDtl = RoleDtl.builder()
						.roleDtlId(rs.getInt(6))
						.roleId(rs.getInt(7))
						.userId(rs.getInt(8))
						.roleMst(roleMst)
						.build();
				
				roleDtls.add(roleDtl);
				i++;
			}
			
			if(user != null) {
			// 완성된 dtl를 user에 넣어줌
				user.setRoleDtls(roleDtls);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return user;
	}
}

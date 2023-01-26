package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RoleInsert {
	
	private DBConnectionMgr pool;
	
	public RoleInsert() {
		pool = DBConnectionMgr.getInstance();
	}
	
	
	
	public int saveRole(String roleName) {
		int successCount = 0;
		
		String sql = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = pool.getConnection();
			
			sql = "insert into role_mst values (0, ?)";
			// RETURN_GENERATED_KEYS를 이용하여 GENERATE_KEYS를 가져옴
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, roleName);
			// 쿼리실행
			successCount = pstmt.executeUpdate();
			
			int newKey = 0;
			
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				newKey = rs.getInt(1);
			}
			
			System.out.println(newKey != 0 ? "새로운 키값: " + newKey : "키가 생성되지 않음");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외가 발생시 freeConnection을 통해 연결은 끊음
			
			pool.freeConnection(con, pstmt, rs);
		}
		
		return successCount;
	}
	public static void main(String[] args) {
		
		RoleInsert roleInsert = new RoleInsert();
	
		int successCount = roleInsert.saveRole("ROLE_TESTER");
		System.out.println("insert 성공 건수: " + successCount);
	
	}
}

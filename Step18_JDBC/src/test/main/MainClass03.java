package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass03 {
	public static void main(String[] args) {
		// 아래의 정보를 member 테이블에 저장
		String name="톰캣";
		String addr="건물 옥상";
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@14.63.164.99:1521:xe";
			conn = DriverManager.getConnection(url, "acorn01", "tiger01");
			System.out.println("Oracle DB 접속 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			String sql="INSERT INTO member"
					+"(num,name,addr)"
					+"VALUES(member_seq.NEXTVAL,?,?)";
			pstmt=conn.prepareStatement(sql);
			// ? 에 순서대로 값을 바인딩 하기
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			// 완성된 sql 문을 수행하고 변화된 row 의 갯수를 리턴 받는다.
			flag=pstmt.executeUpdate();  // 정보 업데이를 해주는 메소드
			System.out.println("회원 정보를 저장했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
	}
}

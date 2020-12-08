package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
 *  member 테이블에서
 *  
 * 	num 804 번인 회원의
 * 
 *  주소를 노량진으로 수정하는 코드를 작성해 보세요.
 */
public class MainClass04 {
	public static void main(String[] args) {
		int num=804;
		String addr="노량진";
		      
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@14.63.164.99:1521:xe";
			conn=DriverManager.getConnection(url, "acorn01", "tiger01");
			System.out.println("Oracle DB 접속 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		      
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			String sql="UPDATE member "
					+ "SET addr=? "
					+ "WHERE num=?";// 첫번째 물음표 이름, 두번째 물음표 주소 / 테이블을 생성할 때 시퀀스를 만들어놓는다. 
			pstmt=conn.prepareStatement(sql);
			// ? 에 순서대로 값을 바인딩 하기
			// 바인딩 => binding => 연결하기 => 붙이기 => ???
			pstmt.setString(1, addr);
			pstmt.setInt(2, num);
			flag=pstmt.executeUpdate();// executeUpdate();-insert, update, delete 셋중에 하나를 수행하는 메소드
			System.out.println("회원 정보를 수정 했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
		            
			}
		}
		if(flag>0) { // 작업의 결과가 0개 이상이면 성공. 성공과 실패를 알 수 있다. 
			System.out.println("작업(UPDATE) 성공");
		}else {
			System.out.println("작업(UPDATE) 실패");
		}
	}
}


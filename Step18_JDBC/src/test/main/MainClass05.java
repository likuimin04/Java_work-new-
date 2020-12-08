package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnect;

/*
 * 
 * member 테이블에서
 * 외원번호가 801 번 회원의 정보를 삭제하는 기능을 완성해 보기
 * hint
 * new DBConnect().getConn();
 * 
 */
public class MainClass05 {
	public static void main(String[] args) {
		//삭제할 회원의 번호
		int num=801;
		// 필요한 참조값을 담을 지역 변수 미리 만들고 초기화 하기
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			// 만들어놓은 DBConnect에서 불러와서 사용.
			// Connection 객체 참조값 불러오기
			conn=new DBConnect().getConn();
			// 실행할 sql 뼈대 만들기
			String sql="DELETE FROM member WHERE num=?";
			// PreparedStatement 객체의 참조값 얻어오기
			pstmt=conn.prepareStatement(sql);
			// ? 값에 바인딩 하기
			pstmt.setInt(1, num);
			// sql 문 실행하고 변화된 row 의 갯수 리턴 받기
			flag=pstmt.executeUpdate();
			System.out.println("DELETE 문 수행 성공.");
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


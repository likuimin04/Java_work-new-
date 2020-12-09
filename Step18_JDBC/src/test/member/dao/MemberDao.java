package test.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import test.member.dto.MemberDto;
import test.util.DBConnect;

/*
 *  회원정보(member 테이블) 의 내용을
 *  select
 *  insert
 *  update
 *  delete
 *  작업을 할 객체를 생성할 클래스 설계하기
 *  
 */
public class MemberDao {
	// 회원 한명의 정보를 저장하는 메소드를 만들어 보세요
	// 메소드 명 : insert
	// 리턴: 알아서
	// 메소드에 전달 하는 인자의 type : MemberDto
	public boolean insert(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			DBConnect c = new DBConnect();
			conn = c.getConn();
			String sql = "INSERT INTO member(name,addr) VALUES(member_seq.NEXTVAL,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getAddr());
			// INSERT 문 수행하기 ( 1개의 row 가 추가 되었으므로 1이 리턴된다)
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					pstmt.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	} 
	
	// 회원 한명의 정보를 수정하는 메소드를 만들어 보세요
	// 메소드 명 : update
	// 리턴: 알아서
	// 메소드에 전달 하는 인자의 type : MemberDto
	public boolean update(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			DBConnect c = new DBConnect();
			conn = c.getConn();
			// 실핼할 sql 문 작성
			String sql="UPDATE member SET addr=? WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			// ? 에 값을 바인딩 할게 있으면 여기서 한다.
			
			pstmt.setString(1, dto.getAddr());
			pstmt.setInt(2, dto.getNum());
			flag=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					pstmt.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	// 회원 한명의 정보를 삭제하는 메소드
	public boolean delect(int num) {

		// 필요한 참조값을 담을 지역 변수 미리 만들고 초기화 하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			// 만들어놓은 DBConnect에서 불러와서 사용.
			// Connection 객체 참조값 불러오기
			conn = new DBConnect().getConn();
			// 실행할 sql 뼈대 만들기
			String sql = "DELETE FROM member WHERE num=?";
			// PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			// ? 값에 바인딩 하기
			pstmt.setInt(1, num);
			// sql 문 실행하고 변화된 row 의 갯수 리턴 받기
			flag = pstmt.executeUpdate();
			System.out.println("DELETE 문 수행 성공.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
		if (flag > 0) { // 작업의 결과가 0개 이상이면 성공. 성공과 실패를 알 수 있다.
			return true;
		} else {
			return false;
		}
	}
}

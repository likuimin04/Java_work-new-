package test.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import test.util.DBConnect;

/*
 *  Scanner 객체를 이용해서 검색할 회원의 번호를 입력 받아서
 *  DB 에서 SELECT 하고
 *  결과 값이 있으면 해당회원의 정보를 콘솔차에 출력하고
 *  결과 값이 없으면 해당 회원은 존재 하지 않습니다. 라고 출력되는 프로그래밍을 해보세요
 * 	hint : String sql="SELECT num,name,addr FROM member WHERE num=?"
 * 	
 *  예)
 *  검색할 회원 번호 입력:
 *  801
 *  801번 회원은 존재 하지 않습니다.
 *  
 *  예)
 *  검색할 회원번호 입력:
 *  850
 *  번호 : 850, 이름: 톰캣, 주소: 건물옥상
 */
public class MainTest01 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("검색할 회원 번호 입력: ");
		int num=scan.nextInt();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=new DBConnect().getConn();
			String sql="SELECT name,addr FROM member WHERE num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				System.out.println("번호: "+num+ "이름: "+name+"주소: "+addr);
			}else {
				System.out.println(num+" 번 회원 정보를 찾을수 없습니다");
			}
		}catch(Exception e) {
			e.printStackTrace();	
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){}
		}
	}
}

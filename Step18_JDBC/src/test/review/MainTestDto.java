package test.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import test.member.dto.MemberDto;
import test.util.DBConnect;

/*
 *  Scanner 객체를 이용해서 검색할 회원의 정보를 입력 받아서
 *  입력받은 숫자를 이용해서 SELECT 문을 수행하고
 *  결과값을 MemberDto 객체를 생성해서 담아보세요.
 *  
 *  결과가 없다면 MemberDto 객체를 생성하지 마세요 (null 인 상태로 두기)
 */
public class MainTestDto {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("검색할 번호 입력: ");
		int num=scan.nextInt();
		
		MemberDto dto=null;
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
				dto=new MemberDto();
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr")); 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(dto==null) {
			System.out.println(num+" 번 회원은 존재하지 않습니다.");
		}else {
			System.out.println("번호: "+dto.getNum()+", 이름: "+dto.getName()+", 주소:"+dto.getAddr());
		}
	}
}

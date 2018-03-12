package com.cafe24.jblog.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.jblog.blog.vo.BlogVo;


public class BlogDao {

	private static final String ID = "jblog";
	private static final String PASSWORD = "jblog";
	private static final String URL = "jdbc:mysql://localhost/jblog";

	private Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			// 1. 드라이버 로딩^_^
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 연결하기
			conn = DriverManager.getConnection(URL, ID, PASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} 

		return conn;
	}


	public boolean insert(BlogVo vo) {
		boolean result = false;
		Connection conn = null;

		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			// 3. SQL 준비
			String sql = "insert into blog values(null, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql); // 준비된 것이지 이 상태에서 커리날리면 오류 걸림

			// 4. 데이터 바인딩(binding)
			
			pstmt.setInt(1, vo.getUserNo());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getImageName());
			pstmt.setString(4, vo.getImagePath());


			
			// 5. SQL문 실행
			int count = pstmt.executeUpdate(); //열의 갯수를 리턴함!
			
			result = (count != 0);
			
			// 6. 결과 처리
			if (count == 0) {
				System.out.println("실패!");
			} else {
				System.out.println("성공!");
			}

		}  catch (SQLException e) {
			System.out.println("에러:" + e);
		} finally {
			// 자원정리(Clean-Up)
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	public boolean delete(int no) {
		boolean result = false;
		Connection conn = null;

		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			// 3. SQL 준비
			String sql = "delete from blog where no = ?";
			pstmt = conn.prepareStatement(sql); // 준비된 것이지 이 상태에서 커리날리면 오류 걸림

			// 4. 데이터 바인딩(binding)
			
			pstmt.setInt(1, no);

			// 5. SQL문 실행
			int count = pstmt.executeUpdate(); //열의 갯수를 리턴함!
			
			result = (count != 0);
			
			// 6. 결과 처리
			if (count == 0) {
				System.out.println("실패!");
			} else {
				System.out.println("성공!");
			}

		}  catch (SQLException e) {
			System.out.println("에러:" + e);
		} finally {
			// 자원정리(Clean-Up)
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}


	public List<BlogVo> getList() {
		List<BlogVo> list = new ArrayList<BlogVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			conn = getConnection();

			// 4. SQL 실행
			String sql = "select * from blog";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			while (rs.next()) {
				BlogVo vo = new BlogVo();
				vo.setNo(rs.getInt(1));
				vo.setUserNo(rs.getInt(2));
				vo.setTitle(rs.getString(3));
				vo.setImageName(rs.getString(4));
				vo.setImagePath(rs.getString(5));
				list.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("에러:" + e);
		} finally {
			// 자원정리(Clean-Up)
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
}

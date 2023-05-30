package jaeun.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DAO {
	// DAO -> Data(DB) Access Object
	// JDBC를 통해서 JAVA <-> DB가 연결이 된다

	// java -> db 연결할 때 쓰는 객체
	protected Connection conn = null;

	// Query문 (SQL, 질의)을 가지고 실행하는 객체
	protected PreparedStatement pstmt = null;

	// Query문 (SQL, 질의)을 가지고 실행하는 객체
	protected Statement stmt = null;

	// SELECT(조회) 결과 값을 반환하는 객체
	protected ResultSet rs = null;

	// DB접속 정보
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "c##test";
	String pw = "1234";

	// DB 연결 메소드
	public void conn() {
		try {
			// 1. 드라이버 로딩
			Class.forName(driver);
			// 2. DB연결
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DB연결 해제 메소드
	public void disconn() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

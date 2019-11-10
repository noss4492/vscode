package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.RoomsixVO;

public class RoomsixDAO {
	//1. 변수 선언
	//2. JDBC 드라이버가 로딩 되어 있는지 체크한다
	//3. DB에 연결을 한다.(Connection)
	//4. SQL문을 작성
	//5. 문장 객체를 생성하고
	//6. 실행(Select ==> ResultSet)
	//7. 다 했다면 레코드별로 내가 하고싶은 처리를 한다.
	//8. 다 썼다면 자원을 반납하자.

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.35:1521:orcl";
	String user = "scott";
	String password = "tiger";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sb = new StringBuffer();

	public RoomsixDAO(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("drivermanager가 연결에 실패했음");
		}
	}
	public boolean isExists(String id, String pw) {
		boolean isOK = false;
//		sb = new StringBuffer();
//		System.out.println("aaaaaaaaaaaa");
		sb.setLength(0);
		sb.append("SELECT id, ename, pwd ");
		sb.append("FROM roomsix ");
		sb.append("WHERE id = ? and pwd = ? ");
		// 로그인시 필요한 정보 대조
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			isOK = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		return false;
		return isOK;
	}
	
	public void insertOne(String id, String name, String pwd, String gender, String cause){
		sb.setLength(0);
		sb.append("INSERT INTO ROOMSIX ");
		sb.append("VALUES ( ? , ? , ? , ? , ? )");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pwd);
			pstmt.setString(4, gender);
			pstmt.setString(5, cause);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL문이 잘못 되었음");
		}
	}
	
	public void close() {
		try {
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

package day21;
//1. 변수 선언
//2. JDBC 드라이버가 로딩 되어 있는지 체크한다
//3. DB에 연결을 한다.(Connection)
//4. SQL문을 작성
//5. 문장 객체를 생성하고
//6. 실행(Select ==> ResultSet)
//7. 다 했다면 레코드별로 내가 하고싶은 처리를 한다.
//8. 다 썼다면 자원을 반납하자.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCEx4 {
	
	
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.35:1521:orcl";
		String user="scott";
		String password = "tiger";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sb.append("INSERT INTO DEPT ");
		sb.append("VALUES (DEPT_DEPTNO.NEXTVAL,?,?) ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
//			pstmt.setInt(1, 97);	// 아 이러면 시퀀스가 번호 뽑아주는구나 ' ';;
			pstmt.setString(1,  "영업3");
			pstmt.setString(2, "서울");
			
//			pstmt.executeUpdate();	// 실행하면 끝.
			int result = pstmt.executeUpdate();
			System.out.println("result : "+result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null)conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

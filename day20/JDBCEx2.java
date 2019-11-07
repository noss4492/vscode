package day20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 부서 테이블 정보를 가져와서 화면에 출력
public class JDBCEx2 {
	public static void main(String[] args) {
		// 1. 변수 선언
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.35:1521:orcl";
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM dept";
		// 2. JDBC 드라이버가 로딩 되어 있는지 체크한다
		// 3. DB에 연결을 한다.(Connection)
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn : " + conn);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없음, 드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("몬가 안맞음, DB 연결 실패함");
		}
		// 4. SQL문을 작성
		// 5. 문장 객체를 생성하고

		// Creates a PreparedStatement object
		// for sending parameterized SQL statements to the DB
		try {
			pstmt = conn.prepareStatement(sql);
			// 6. 실행(Select ==> ResultSet)
			rs = pstmt.executeQuery();
			// 7. 다 했다면 레코드별로 내가 하고싶은 처리를 한다.
			while (rs.next()) {
				int deptno = rs.getInt("deptno");// 이름써도 되고 인덱스 써도 되고
				String dname = rs.getString(2); // 재사용성 별루~ ' 3'
				String loc = rs.getString("loc");
				System.out.printf("%2d %12s %12s \n", deptno, dname, loc);
			}
		} catch (SQLException e) {
			System.out.println("SQL문이 이상해;;");
		} finally {
			// 8. 다 썼다면 자원을 반납하자.
			if (rs != null)
				try {
					rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}

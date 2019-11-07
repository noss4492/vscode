package day20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 부서번호 10번 부서 사원의 사번, 이름, job을 콘솔에 출력
public class JDBCEx3 {
	public static void main(String[] args) {
		// 1. 변수 선언
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.35:1521:orcl";
		String user = "scott";
		String password = "tiger";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 2. JDBC 드라이버가 로딩 되어 있는지 체크한다
		// 3. DB에 연결을 한다.(Connection)
		try {
			Class.forName(driver);
			// Returns the Class object associated
			// with the class or interface with the given string name.
			// 만약 발견되지 않는다면 ClassNotFoundException발생.
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Class.forName(driver) 에서 예외");
		} catch (SQLException e) {
			System.out.println("DriverManager의 연결 메소드에서 에러.");
		}

		// 4. SQL문을 작성
		String sql = "SELECT empno, ename, job FROM emp WHERE deptno = 10";
		System.out.printf("%-5s %-12s %-12s \n", "사번", "이름", "부서번호" );
		// 스트링버퍼 추 ' 3'~ 나중에 인자로 다시 받을땐 .toString() 해서 너~어~요~ ' '~
//		StringBuffer sql_tmp = new StringBuffer();
//		sql_tmp.append("머시기 ");
//		sql_tmp.append("저시기 ");
		// sql_tmp.toString()
		
		// 5. 문장 객체를 생성하고
		// 컴파일 준비 단계, 컴파일준비상태인 인터페이스로 구현한 pstmt 객체
		// 6. 실행(Select ==> ResultSet)
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // return ResultSet

			// 7. 다 했다면 레코드별로 내가 하고싶은 처리를 한다.
			// rs의 row select cursor을 움직여서 출력해보자.
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				System.out.printf("%-5d %-12s %-12s \n", empno, ename, job);
			}
		} catch (SQLException e) {
			System.out.println("SQL문이 이상해서 예욍");
			
			// 8. 다 썼다면 자원을 반납하자.
		} finally {
			if(rs != null) {
					try {
						rs.close();	// to free~
						if(conn != null) conn.close();
						if(pstmt != null) pstmt.close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
	}
}

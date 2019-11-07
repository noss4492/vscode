package day20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCEx4 {
	//1. 변수 선언
	//2. JDBC 드라이버가 로딩 되어 있는지 체크한다
	//3. DB에 연결을 한다.(Connection)
	//4. SQL문을 작성
	//5. 문장 객체를 생성하고
	//6. 실행(Select ==> ResultSet)
	//7. 다 했다면 레코드별로 내가 하고싶은 처리를 한다.
	//8. 다 썼다면 자원을 반납하자.

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.35:1521:orcl";	//
		String user = "scott";
		String pw = "tiger";
		
		Connection conn = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			
		} catch (ClassNotFoundException e) {
			// 클래스 포네임 암것도 못 찾아왔어
		} catch (SQLException e) {
			// 드라이버매니저에서 연결 실패했서
		}
		
		//연결하고
		//객체에 담기
		PreparedStatement psmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT EMPNO, ENAME, JOB, SAL ");
		sql.append("FROM EMP ");
		sql.append("WHERE SAL >= 2400 ");
		sql.append("AND JOB = 'MANAGER' ");
		
		
		// 컴파일전단계 준비 -> 지정된 형 객체로 담아서 exe한걸 받아서 내맘대로 요리해서 출력
		ResultSet rs = null;
		try {
			psmt = conn.prepareStatement(sql.toString());
			rs = psmt.executeQuery();
			while(rs.next()) {
				int empno = rs.getInt("EMPNO");
				String ename = rs.getString("ENAME");
				String job = rs.getString("JOB");
				int sal = rs.getInt("SAL");
				System.out.printf("%d\t%s\t%s\t%d\n",empno, ename, job, sal);
			}
		} catch (SQLException e) {
			// 야 이거 SQL문이 좀 이상하다
		} finally {
		// free해지는 부분
			if(rs!=null) {
				try {
					rs.close();
				if(psmt!=null)
						psmt.close();
				if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

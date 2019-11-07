package day20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;	//JDBC는 다 인터페이스, 왜냐? 회사마다 다르게 쓰니까
import java.sql.SQLException;

// 서순 잘 보아ㅛㅐ
public class JDBCEx1 {
	public static void main(String[] args) {
		// 1. 변수 선언
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.35:1521:orcl";
		// jdbc에서 오라클연결하는데 thin방식으루다가. 접속할 서버ip 포트 dbname
		// thin 경량 드라이버 fat 무거운 드라이버 방식
		String user = "scott";
		String password = "tiger";

		Connection conn = null; // 왜 이 위치로? 밑에서 없을까봐
		try {
			// 2. JDBC 드라이버 로딩 되어 있는지 체크
			Class.forName(driver);
			// 3. 연결(Connection)
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn :" + conn);
			// uri : uniform resource locator
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
		}

		// 4. sql문 작성
		// 최대한 여기서 걸러내서 네트워크 트래픽을 줄이자.
		String sql = "SELECT empno, ename, sal FROM emp WHERE sal >= 3000";
	
		// 5. 문장 객체 생성(보낼땐 객체니까)
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// 6. 실행(select ==> ResultSet)
			rs = pstmt.executeQuery(); // 데이터 막 찾아온 애 : 리절트셋
			System.out.println(rs);
			// 7. 레코드별 처리
			rs.next(); // 다음(첫번째) 레코드로 이동해
			// 해당 컬럼 데이터 가져오기
			int empno = rs.getInt("EMPNO");
			int sal = rs.getInt("sal");

			System.out.print("    사번            이름      급여\n");
			System.out.println("----------------");
			String ename = rs.getString("ename");
			System.out.printf("%5s %8s %5s \n", empno, ename, sal);
			// 오오오ohohohohoo
			while (rs.next() == true) {
				empno = rs.getInt("EMPNO");
				ename = rs.getString("ename");
				sal = rs.getInt("sal");
				System.out.printf("%5s %8s %5s \n", empno, ename, sal);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// 8. 자원 반납
				try {
					if(rs!=null) 
						rs.close();
					if(pstmt != null)
						pstmt.close();
					if(conn!=null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}

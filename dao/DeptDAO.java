package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.DeptVO;

// 타자 치기 귀찮으니까 ~ 객체지향이니까~

public class DeptDAO {
	// 멤버변수 DB연결
//	String driver = "oracle.jdbc.driver.OracleDriver";
//	String url = "jdbc:oracle:thin:@192.168.0.35:1521:orcl";
//	String user = "scott";
//	String password = "tiger";

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@orcl.ckyvzseloumz." + "ap-northeast-2.rds.amazonaws.com:1521:orcl";
	String user = "admin";
	String password = "tigertiger";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	StringBuffer sb = new StringBuffer();
	ResultSet rs = null;

	public DeptDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn : " + conn);
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("드라이버매니저가 DB연결 실패함");
		}

	}// Construct end

	// 전체 조회
	// 1건 조회(10번 부서 정보 가져오기)
	public DeptVO selectOne(int deptno) { // 그냥 그릇채로 리턴해서 넘겨줌ㅇ
		// 4. SQL문을 작성
		sb.setLength(0);// 기존 문장 전부 제거(오 신기한 사용법이네)
		sb.append("SELECT deptno, dname, loc ");
		sb.append("FROM dept ");
		sb.append("WHERE deptno = ? ");

		DeptVO vo = null;
		// 5. 문장 객체를 생성하고
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, deptno);

			// 6. 실행(Select ==> ResultSet)
			rs = pstmt.executeQuery();

			// 7. 다 했다면 레코드별로 내가 하고싶은 처리를 한다.
			rs.next();
			String dname = rs.getString("dname");
			String loc = rs.getString("loc");

			vo = new DeptVO(deptno, dname, loc);
//			vo = new DeptVO();
//			vo.setDeptno(deptno);
//			vo.setDname(dname);`
//			vo.setLoc(loc);
		} catch (SQLException e) {
			System.out.println("SQL문 잘못댐");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 8. 다 썼다면 자원을 반납하자.

		return vo;
	}// select end

	public void insertOne(String dname, String loc) {
		// 4. SQL문을 작성
		// 5. 문장 객체를 생성하고
		// 6. 실행(Select ==> ResultSet)
		// 7. 다 했다면 레코드별로 내가 하고싶은 처리를 한다.
		// 8. 다 썼다면 자원을 반납하자.
		sb.setLength(0);// 기존 문장 전부 제거(오 신기한 사용법이네)
		sb.append("INSERT INTO dept ");
		sb.append("VALUES (DEPT_DEPTNO.NEXTVAL, ?, ?)");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL문 miss");
			e.printStackTrace();
		}
	}

	public void deleteOne(int deptno) {
		sb.setLength(0);
		sb.append("DELETE FROM DEPT ");
		sb.append("WHERE DEPTNO = ? ");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, deptno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateOne(int deptno, String dname, String loc) {
		sb.setLength(0);
		sb.append("UPDATE DEPT ");
		sb.append("SET DNAME = ?, LOC = ? ");
		sb.append("WHERE DEPTNO = ?");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(2, loc);
			pstmt.setString(1, dname);
			pstmt.setInt(3, deptno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<DeptVO> selectAll() {
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		sb.setLength(0);
		sb.append("SELECT deptno, dname ,loc ");
		sb.append("FROM dept ");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				DeptVO vo = new DeptVO(deptno, dname, loc);
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("쿼리를 잘 만들거라~");
		}
		return list;
	}
	
	public void close() {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println("자원반납 실패");
			}
	}
}
